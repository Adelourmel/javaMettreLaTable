package view;

import control.DiapositiveListener;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.awt.*;

public class Diapositive extends Panel {
    private int index;
    private int nbSlide;
    private String file;

    private JPanel header;
    private JPanel footer;
    private JLabel image;

    private JButton suivant;
    private JButton precedant;
    private JButton exit;

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
        this.footer = new JPanel(new GridLayout(1,2));
        this.image = new JLabel("?/img/");
        this.header = new JPanel();

        this.exit = new JButton("exit");
        this.precedant = new JButton("précédent");
        this.suivant = new JButton("suivant");

        this.header.add(exit);
        this.footer.add(suivant);
        this.footer.add(precedant);

        add(this.header);
        add(this.image);
        add(this.footer);
    }

}
