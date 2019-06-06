package control;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class listen the menu
 * @author BIZOUARN Aymeric
 * @author BOISNARD Noéwen
 * @author DELOURMEL Arnaud
 *
 */
public class MenuListener implements ActionListener {

    private Menu menu;
    /**
     * Constructor
     * @param menu GUI menu
     */
    public MenuListener(Menu menu) {
        this.menu = menu;
    }

    /**
     * action listener
     * @param e the event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.menu.getbuttonMettreLaTable()) {
            this.menu.getGUI().showDiapo("Mettre la table");
        }
    }
}
