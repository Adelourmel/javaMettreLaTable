package view;

import control.DiapositiveListener;

import javax.swing.*;
import java.awt.*;

public class Diapositive extends JPanel {
    private int index;
    private int nbSlide;
    private String file;

    private JPanel header;
    private JPanel footer;
    private JPanel content;

    private JButton suivant;
    private JButton precedant;
    private JButton exit;

    public Diapositive() {
        super();
        makePanel();
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
        this.content = new JPanel();
        this.header = new JPanel(new GridLayout(1,3));

        this.exit = new JButton("exit");
        this.precedant = new JButton("précédent");
        this.suivant = new JButton("suivant");

        this.header.add(exit);
        this.footer.add(suivant);
        this.footer.add(precedant);

        add(this.header,BorderLayout.NORTH);
        add(this.content,BorderLayout.CENTER);
        add(this.footer,BorderLayout.SOUTH);
    }

}
