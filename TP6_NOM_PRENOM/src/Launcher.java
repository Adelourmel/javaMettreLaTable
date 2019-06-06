import view.*;

/**
 * Launcher
 * @author BIZOUARN Aymeric
 * @author BOISNARD Noéwen
 * @author DELOURMEL Arnaud
 */
public class Launcher {
    public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new GUI();
      }
    });
  }
}
