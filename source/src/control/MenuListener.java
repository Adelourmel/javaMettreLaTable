package control;

import view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
  private Menu gui;
  public MenuListener(GUI gui) {
    this.menu = menu;
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.gui.getMenu().getbuttonMettreLaTable()) {
      System.out.println("YOp");
    }
  }
}
