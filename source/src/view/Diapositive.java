package view;

import control.DiapositiveListener;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.awt.*;

public class Diapositive extends JPanel {
    private int index;
    private int nbSlide;
    private String file;

    private JLabel image;

    public Diapositive() {
        super(new GridLayout(3,1));
    }

    public Diapositive(int nbSlide, String title) {
        super();
        this.nbSlide = nbSlide;
        this.file = title;
        this.index = 0;
        makePanel();
    }

    public void makePanel(){
        this.image = new JLabel("?/img/");
        add(this.image);
    }

}
