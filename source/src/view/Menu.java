package view;

import control.MenuListener;
import model.Chrono;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Menu extends JPanel {

  private MenuListener listener;
  private JButton buttonMettreTable;

  public Menu(Chrono chrono) {
    super();

    this.listener = new MenuListener(this);

    this.setLayout(new GridLayout(3, 1));

    createChoiceBox(chrono);
  }

  public void createChoiceBox(Chrono chrono) {

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

  }
}
