package view;

import control.MenuListener;

import javax.swing.*;
import java.awt.BoardLayout;

public class Menu extends JPanel {

  private MenuListener listener;

  public Menu(Chrono chrono) {
    super();

    this.listener = new MenuListener(this);

    this.setLayout(new BoardLayout());

    createChoiceBox(chrono)
  }

  public void createChoiceBox(Chrono chrono) {

    createRow("Mettre la table", chrono.getBestTime());
    createRow("Préparer un repas complet", chrono)
  }
  public JButton createRow(String title, int scores) {

  }
}
