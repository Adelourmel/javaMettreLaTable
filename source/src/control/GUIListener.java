package control;

import view.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIListener implements ActionListener {
    private GUI gui;

    public GUIListener(GUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if(this.gui.getTitle().equals("Menu")){

        } else {
            this.gui.showMenu();
        }
    }
}
