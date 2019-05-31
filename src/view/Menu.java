package view;

import control.MenuListener;
import model.Chrono;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.*;
import javax.swing.border.*;

public class Menu extends JPanel {

    public GUI gui;
    private JButton buttonMettreTable;

    public Menu(GUI gui) {
        super();

        this.setLayout(new GridLayout(3, 1));
        createChoiceBox(gui.getChrono());
        this.gui = gui;
    }

    public void createChoiceBox(Chrono chrono) {

        String temps;
        if (chrono.getBestTime() == -1) {
            temps = "__:__";
        } else {
            temps = chrono.beautify(chrono.getBestTime());
        }

        this.buttonMettreTable = createRow("Mettre la table", temps);
        this.buttonMettreTable.addActionListener(new MenuListener(this));

        createRow("Preparer un repas complet", "__:__").setEnabled(false);
        createRow("Débarrasser la table", "__:__").setEnabled(false);
    }

    public JButton createRow(String title, String temps) {
        JPanel tmp = new JPanel();
        tmp.setLayout(new BorderLayout());


        JButton button = new JButton("<html><font size=15 color = white >" + title + "</font></html>");

        button.setBackground(new Color(139, 195, 74));

        JLabel text = new JLabel("<html><font size=4 color = black>Meilleur temps : " + temps + "</font></html>");

        text.setOpaque(true);
        text.setBackground(Color.WHITE);


        Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
        Border empty = new EmptyBorder(20, 20, 20, 20);
        CompoundBorder border = new CompoundBorder(line, empty);
        text.setBorder(border);


        tmp.add(button, BorderLayout.CENTER);
        tmp.add(text, BorderLayout.EAST);


        tmp.setPreferredSize(new Dimension(50, 50));
        this.add(tmp);

        return button;

    }

    public JButton getbuttonMettreLaTable() {
        return this.buttonMettreTable;
    }
}
