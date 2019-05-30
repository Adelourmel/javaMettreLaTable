package control;

import view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIListener implements ActionListener {
    private GUIListener guiListener;

    GUIListener(GUIListener guiListener) {
        this.guiListener = guiListener;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
