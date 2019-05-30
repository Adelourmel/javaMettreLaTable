package test;

import model.Chrono;

public class TestChrono {
  public static void main(String[] args) {

    System.out.println("TESt chrono");
    Chrono test = new Chrono("../data/test.bin");
    test.start();
    long i = -1000000000;
    while (i < 1000000000) {
      System.out.println("yop");
      i++;
    }

    int tmp = test.stop();

    if (tmp == -1) {
      System.out.println("nouveau record : " + test.beautify(test.getFinalTime()));
    }
    else {
      System.out.println(test.beautify(test.getFinalTime()) + " votre record est : " + test.beautify(tmp));
    }
  }
}
