package view;

import model.JSONRead;

import javax.swing.*;
import java.awt.*;

public class Diapositive extends JPanel {
    private int index;
    private int nbSlide;
    private String file;

    private JLabel image;
    private JLabel text;

    public Diapositive() {
        super(new GridLayout(3, 1));
        this.index = 0;
    }

    public void getContent(int index) {
        getText(index);
        getImage(index);
    }

    public void getText(int index) {

    }

    public void getImage(int index) {

    }

}
