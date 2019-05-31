package view;

import model.JSONRead;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.FileReader;

public class Diapositive extends JPanel {

    public GUI gui;

    private int index;
    private int maxIndex; //use for progress bar.
    private String title;
    private String location;
    private String desc;

    private JLabel image;
    private JTextPane text;
    private boolean fin;

    public Diapositive() {
        super(new GridLayout(1, 2));
        this.index = 1;
    }

    public Diapositive(GUI gui, String title, String location) {
        super(new GridLayout(1, 2));
        setBackground(Color.white);
        this.text = new JTextPane();
        Font font = new Font("Verdana", Font.BOLD, 20);
        this.text.setFont(font);
        this.text.setEditable(false);
        this.text.setMargin(new Insets(100,50,50,50));
        this.image = new JLabel();
        this.image.setHorizontalAlignment(SwingConstants.CENTER);
        add(text);
        add(image);
        this.gui = gui;
        this.title = title;
        this.location = location;
        this.index = 1;
        this.fin = false;
        getContent(this.index);
        getMaxIndex();
        gui.getChrono().start();
    }

    public void getContent(int index) {
        getText(index);
        getImage(index);
        gui.getProgressBar().setValue(this.index);
    }

    public void getText(int index) {
        try {
            this.text.setText(new JSONRead().readJSON(this.index)[1]);
        } catch (Exception e) {
            gui.getChrono().stop();
            fin();
            this.fin = true;
        }
    }

    public void getImage(int index) {
        try {
            Image img_new = (new ImageIcon(new JSONRead().readJSON(this.index)[2])).getImage().getScaledInstance(350, 350,  java.awt.Image.SCALE_SMOOTH);
            this.image.setIcon(new ImageIcon(img_new));
        } catch (Exception e) { }
    }

    public void getNext() {
        if(this.fin){
            gui.showMenu();
        } else {
            this.index++;
            getContent(this.index);
            this.gui.getPrecedent().setEnabled(true);
        }
    }

    public void getPrevious() {
        this.index--;
        getContent(this.index);
        if (this.index == 1) {
            this.gui.getPrecedent().setEnabled(false);
        }
        this.fin = false;
    }

    public void fin() {
        String text = "Bravo ! \n";
        String temps = gui.getChrono().beautify(gui.getChrono().getFinalTime());
        text += "Vous avez effectué la tache en "+temps+"\n";
        String record = gui.getChrono().beautify(gui.getChrono().getBestTime());
        text += "votre record précedent étant "+record+"\n";
        System.out.println("finalTime : "+gui.getChrono().getFinalTime());

        this.text.setText(text);
        this.image.setIcon(new ImageIcon("..\\data\\img\\coupe.png"));
    }

    public void getMaxIndex() {
        this.maxIndex = 1;
        try {
            while (true) {
                new JSONRead().readJSON(this.maxIndex);
                this.maxIndex ++;
            }
        }
        catch (Exception e){}
        finally {
            this.gui.getProgressBar().setMinimum(0);
            this.gui.getProgressBar().setMaximum(this.maxIndex);
        }
    }
}
