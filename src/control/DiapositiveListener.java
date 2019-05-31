package control;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiapositiveListener implements ActionListener {

    private GUI gui;

    public DiapositiveListener(GUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == gui.getPrecedent()) {
            gui.getDiapo().getPrevious();
        } else if (button == gui.getSuivant()) {
            gui.getDiapo().getNext();
        }
    }
}
