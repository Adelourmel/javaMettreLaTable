package view;

import control.MenuListener;
import model.Chrono;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.*;
import javax.swing.border.*;

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
    createRow("Preparer un repas complet", "0").setEnabled(false);
    createRow("Debarraser la table", "0").setEnabled(false);
  }

  public JButton createRow(String title, String temps) {
    JPanel tmp = new JPanel();
    tmp.setLayout(new BorderLayout());
    JButton button = new JButton("<html><font size=15 color = white >" + title + "</font></html>");

    button.setBackground(new Color(104, 159, 56));

    JLabel text = new JLabel("<html><font size=4 color = black>Meilleur temps : " + temps + "mn</font></html>");
    text.setOpaque(true);
    text.setBackground(Color.WHITE);
    Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
    Border empty = new EmptyBorder(20, 20, 20, 20);
    CompoundBorder border = new CompoundBorder(line, empty);
    text.setBorder(border);

    tmp.add(button, BorderLayout.CENTER);
    tmp.add(text, BorderLayout.EAST);

    this.add(tmp);

    return button;

  }
}
