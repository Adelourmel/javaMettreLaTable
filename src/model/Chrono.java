package model;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * This class allow to time and can save the time in file if the time is less than the last
 * @author Arnaud Delourmel
 * @author Noéwen Boisnard
 * @author Aymeric Bizouarn
 *
 */
public class Chrono {

    private long timeInit;
    private int finalTime;
    private String fileName;

  /**
   * Construcotr
   * @param fileName the name of the file
   */
    public Chrono(String fileName) {
        this.timeInit = 0;
        this.finalTime = 0;
        this.fileName = fileName;
    }

    /**
     * This method start the timer
     */
    public void start() {
        this.timeInit = System.currentTimeMillis();
    }

    /**
     * This method stop the time and save the time if it's the best time
     * @return if the time is the best return this time and -1 if it isn't the best time
     */
    public int stop() {
        this.finalTime = (int) (System.currentTimeMillis() - this.timeInit);
        return saveIfItBest();
    }


    /**
     * This function allow to save the time if it's the best time
     * @return if the time is the best return this time and -1 if it isn't the best time
     */
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


/**
 * Read the time store in the file
 * @return the best time
 */
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

/**
 * Write in the file the new time. Create file if the file doesn't exist
 */
    private void writeInFile() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(this.fileName));

            out.writeInt(this.finalTime);

            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Convert nanoseconde time to MM:SS
     * @param  time nanoseconde time
     * @return      String with mm:ss
     */
    public String beautify(int time) {
        return new SimpleDateFormat("mm:ss").format(new Date(time));
    }

/**
 * Allow to have the time of the chrono
 * @return the time of the chrono
 */
    public int getFinalTime() {
        return this.finalTime;
    }
}
