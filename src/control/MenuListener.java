package control;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
  private Menu menu;
  public MenuListener(Menu menu) {
    this.menu = menu;
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.menu.getbuttonMettreLaTable()) {
      System.out.println("YOp");
      this.menu.gui.showDiapo("Mettre la table","..\\data\\mettreTable");
    }
  }
}
