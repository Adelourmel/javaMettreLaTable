package model;

public class Chrono {

  private long timeInit;
  private long finalTime;

  public Chrono() {
    this.timeInit = 0;
    this.finalTime = 0;
  }

  public void start() {
    this.timeInit = System.currentTimeMillis();
  }

  public void stop() {
    this.finalTime = System.currentTimeMillis() - this.timeInit;
  }


  public void saveIfItBest(long newTime) {

  }


  public String beautify() {
    String texteSecondes;
    String texteMinutes;

    if (this.secondes < 10) {
      texteSecondes = "0" + this.secondes;
    }
    else {
      texteSecondes = "" + this.secondes;
    }
    if (this.minutes < 10) {
      texteMinutes = "0" + this.minutes;
    }
    else {
      texteMinutes = "" + this.minutes;
    }
    return texteMinutes + ":" + texteSecondes;
  }
}
