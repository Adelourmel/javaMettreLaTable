package view;

import model.JSONRead;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Diapositive
 * Initalize the slides and show them
 * @author BIZOUARN Aymeric
 * @author BOISNARD Noéwen
 * @author DELOURMEL Arnaud
 */
public class Diapositive extends JPanel {

    private GUI gui;

    private int index;
    private int maxIndex; // used for progress bar.
    private String title;
    private String location;

    private JLabel image;
    private JTextPane text;
    private boolean fin;

    private ArrayList<String> t = new ArrayList<String>();
    private ArrayList<Image> im = new ArrayList<Image>();

    /**
     * Diapositive Constructor for the GridLayout
     */
    public Diapositive() {
        super(new GridLayout(1, 2));
        this.index = 0;
    }

    /**
     * Diapositive's Constructor
     * @param  gui      GUI object
     * @param  title    Title of the slide
     * @param  location location of the slide
     */
    public Diapositive(GUI gui, String title) {
        super(new GridLayout(1, 2));
        initSlides();
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
        this.index = 0;
        this.fin = false;
        getContent(this.index);
        getMaxIndex();
        gui.getChrono().start();
    }

    /**
     * Initialize slides at the first launch
     */
    private void initSlides() {
        for (int i = 1; i < 34; i++) {
            try {
                String j = new JSONRead().readJSON(i)[1];
                String im_s = new JSONRead().readJSON(i)[2];
                Image img_new = (new ImageIcon(im_s)).getImage().getScaledInstance(350, 350,  java.awt.Image.SCALE_SMOOTH);
                this.t.add(j);
                this.im.add(img_new);
            } catch (Exception e) {}
        }
    }

    /**
     * Get the content of slide
     * @param index Slide index
     */
    private void getContent(int index) {
        getText(index);
        getImage(index);
        gui.getProgressBar().setValue(this.index);
    }

    /**
     * Get the text of the slide from the ArrayList
     * @param index Slide index
     */
    private void getText(int index) {
        try {
            this.text.setText(this.t.get(index));
        } catch (Exception e) {
            gui.getChrono().stop();
            fin();
            this.fin = true;
        }
    }

    /**
     * Get the picture of the slide from the ArrayList
     * @param index Slide index
     */
    private void getImage(int index) {
        try {
            this.image.setIcon(new ImageIcon(this.im.get(this.index)));
        } catch (Exception e) { }
    }

    /**
     * Get the next slide
     */
    public void getNext() {
        if(this.fin){
            gui.showMenu();
        } else {
            this.index++;
            getContent(this.index);
            this.gui.getPrecedent().setEnabled(true);
        }
    }

    /**
     * Get the previous slide
     */
    public void getPrevious() {
        this.index--;
        getContent(this.index);
        if (this.index == 1) {
            this.gui.getPrecedent().setEnabled(false);
        }
        this.fin = false;
    }

    /**
     * Print the end slide and give the time and record
     */
    private void fin() {
        String text = "Bravo ! \n";
        String temps = gui.getChrono().beautify(gui.getChrono().getFinalTime());
        temps = temps.substring(0,temps.indexOf(":"))+" min "+temps.substring(temps.indexOf(":")+1)+" sec";
        text += "Vous avez effectué la tâche en "+temps+" !\n";
        String record = gui.getChrono().beautify(gui.getChrono().getBestTime());
        record = record.substring(0,record.indexOf(":"))+" min "+record.substring(record.indexOf(":")+1)+" sec";
        text += "Votre record actuel est de "+record+"\n";

        this.text.setText(text);
        this.image.setIcon(new ImageIcon("./data/img/coupe.png"));
    }

    /**
     * Get the max index
     */
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
            this.gui.getProgressBar().setMaximum(this.maxIndex-1);
        }
    }
}
