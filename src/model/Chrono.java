package model;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Chrono {

    private long timeInit;
    private int finalTime;
    private String fileName;

    public Chrono(String fileName) {
        this.timeInit = 0;
        this.finalTime = 0;
        this.fileName = fileName;
    }

    public void start() {
        this.timeInit = System.currentTimeMillis();
    }

    public int stop() {
        this.finalTime = (int) (System.currentTimeMillis() - this.timeInit);
        System.out.println("Time : " + finalTime);
        return saveIfItBest();
    }


    private int saveIfItBest() {

        int score = getBestTime();


        if (score > this.finalTime) {
            score = -1;
            writeInFile();

        } else if (score == -1) {
            writeInFile();
        }

        return score;


    }

    public int getBestTime() {

        int ret = -1;

        try {
            DataInputStream in = new DataInputStream(new FileInputStream(this.fileName));

            ret = in.readInt();
            in.close();

        } catch (IOException e) {
            ret = -1;
        }

        return ret;

    }


    private void writeInFile() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(this.fileName));

            out.writeInt(this.finalTime);

            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public String beautify(int time) {
        return new SimpleDateFormat("mm:ss").format(new Date(time));
    }

    public int getFinalTime() {
        return this.finalTime;
    }
}
