package control;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listening Action in for the diapositive panel.
 *
 * @author BIZOUARN Aymeric
 * @author BOISNARD Noéwen
 * @author DELOURMEL Arnaud
 */
public class DiapositiveListener implements ActionListener {

    private GUI gui;

    /**
     * Initialise the DiapositiveListener.
     *
     * @param gui The graphical user interface.
     */
    public DiapositiveListener(GUI gui) {
        this.gui = gui;
    }

    /**
     * Click on object detection.
     *
     * @param e The ActionEvent.
     */
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == gui.getPrecedent()) {
            gui.getDiapo().getPrevious();
        } else if (button == gui.getSuivant()) {
            gui.getDiapo().getNext();
        }
    }
}
