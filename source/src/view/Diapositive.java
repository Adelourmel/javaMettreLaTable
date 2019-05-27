package view;

import control.DiapositiveListener;

import javax.swing.JPanel;

public class Diapositive extends JPanel {
    private int index;
    private int nbSlide;
    private String file;

    public Diapositive() {
        super();
    }

    public Diapositive(int nbSlide, String title) {
        super();
        this.nbSlide = nbSlide;
        this.title = title;
        this.index = 0;
    }

}
