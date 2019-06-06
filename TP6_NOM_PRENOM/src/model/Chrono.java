package model;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Chrono
 * Time the user and save it in a file if there is a new record
 * @author BIZOUARN Aymeric
 * @author BOISNARD Noéwen
 * @author DELOURMEL Arnaud
 *
 */
public class Chrono {

    private long timeInit;
    private int finalTime;
    private String fileName;

  /**
   * Constructor
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
     * This method stop the timer and save it if it's the best time
     * @return return time if it's best time, -1 if not
     */
    public int stop() {
        this.finalTime = (int) (System.currentTimeMillis() - this.timeInit);
        return saveIfItBest();
    }


    /**
     * This function allow to save the time if it's the best time
     * @return return time if it's best time, -1 if not
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
 * Read the time and store it in the file
 * @return best time
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
     * Write the new time in the file. Create file if the file doesn't exist.
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
     * Convert nanosecond time to MM:SS
     * @param  time nanosecond time
     * @return      String with mm:ss
     */
    public String beautify(int time) {
        return new SimpleDateFormat("mm:ss").format(new Date(time));
    }

/**
 * Allow to have the time of the chronometer
 * @return time of the chronometer
 */
    public int getFinalTime() {
        return this.finalTime;
    }
}
