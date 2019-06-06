package control;

import view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listening Action in the GUI panel.
 */
public class GUIListener implements ActionListener {
    /**
     * The Gui window listen.
     */
    private GUI gui;

    /**
     * Initialise the GUIListener.
     * @param gui The GUIListener.
     */
    public GUIListener(GUI gui) {
        this.gui = gui;
    }

    /**
     * Click on object detection.
     * @param e The ActionEvent.
     */
    public void actionPerformed(ActionEvent e) {
        if (this.gui.getTitle().contains("Menu")) {
            this.gui.dispose();
        } else {
            this.gui.showMenu();
        }
    }
}
