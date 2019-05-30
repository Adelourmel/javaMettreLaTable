package view;

import control.MenuListener;
<<<<<<< HEAD
import model.Chrono;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Menu extends JPanel {

  private MenuListener listener;
  private JButton buttonMettreTable;
=======
import model.*;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private MenuListener listener;
>>>>>>> 71a9c84cbf9d84ee6133c8cc2479ece074d9f509

    public Menu(Chrono chrono) {
        super();

        this.listener = new MenuListener(this);

<<<<<<< HEAD
    this.setLayout(new GridLayout(3, 1));

    createChoiceBox(chrono);
  }
=======
        this.setLayout(new BorderLayout());

        //createChoiceBox(chrono);
    }
>>>>>>> 71a9c84cbf9d84ee6133c8cc2479ece074d9f509

    public void createChoiceBox(Chrono chrono) {
        createRow("Mettre la table", chrono.getBestTime());
        createRow("Préparer un repas complet", chrono.getBestTime());
    }

<<<<<<< HEAD
    String temps;
    if (chrono.getBestTime() == -1) {
      temps = "0";
    }
    else {
      temps = chrono.beautify(chrono.getBestTime());
    }

    this.buttonMettreTable = createRow("Mettre la table", temps);
    createRow("Préparer un repas complet", "0").setEnabled(false);
    createRow("Débarraser la table", "0").setEnabled(false);
  }
  public JButton createRow(String title, String temps) {
    JPanel tmp = new JPanel();
    tmp.setLayout(new BorderLayout());
    JButton button = new JButton(title);
    JLabel text = new JLabel("Meilleur temps : " + temps + "mn");
    tmp.add(button, BorderLayout.CENTER);
    tmp.add(button, BorderLayout.EAST);

    this.add(tmp);

    return button;
=======
    public JButton createRow(String title, int scores) {
        JButton ret = new JButton();
>>>>>>> 71a9c84cbf9d84ee6133c8cc2479ece074d9f509

        return ret;
    }
}
