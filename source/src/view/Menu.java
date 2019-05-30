package view;

import control.MenuListener;

import javax.swing.*;
import java.awt.BoardLayout;

public class Menu extends JPanel {

  private MenuListener listener;

  public Menu() {
    super();

    this.listener = new MenuListener(this);

    this.setLayout(new BoardLayout());
  }

  public void createChoiceBox() {

    createRow("Mettre la table", )
  }
  public JPanel createRow(String title, int scores) {

  }
}
