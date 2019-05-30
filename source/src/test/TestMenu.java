package test;

import view.Menu;
import model.Chrono;
import javax.swing.JFrame;

public class TestMenu extends JFrame {
    public TestMenu() {

      super("Test");
      Chrono test = new Chrono("../data/score.bin");
      add(new Menu(test));

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
    }

    public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() { new TestMenu();}
      });
    }
}
