package view;

import control.MenuListener;
import model.*;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private MenuListener listener;

    public Menu(Chrono chrono) {
        super();

        this.listener = new MenuListener(this);

        this.setLayout(new BorderLayout());

        //createChoiceBox(chrono);
    }

    public void createChoiceBox(Chrono chrono) {
        createRow("Mettre la table", chrono.getBestTime());
        createRow("Préparer un repas complet", chrono.getBestTime());
    }

    public JButton createRow(String title, int scores) {
        JButton ret = new JButton();

        return ret;
    }
}
