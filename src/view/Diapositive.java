package view;

import model.JSONRead;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class Diapositive extends JPanel {

    public GUI gui;

    private int index;
    private String title;
    private String location;
    private String desc;

    private JLabel image;
    private JTextArea text;
    private boolean fin;

    public Diapositive() {
        super(new GridLayout(1, 2));
        this.index = 0;
    }

    public Diapositive(GUI gui, String title, String location) {
        super(new GridLayout(1, 2));
        setBackground(Color.white);
        this.text = new JTextArea();
        this.text.setAlignmentX(CENTER_ALIGNMENT);
        this.text.setMargin(new Insets(50,50,50,50));
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
    }

    public void getContent(int index) {
        getText(index);
        getImage(index);
    }

    public void getText(int index) {
        try {
            // FileReader fr = new FileReader(this.location + "\\" + this.index + ".txt");
            // Scanner scanner = new Scanner(fr);
            // String textF = "";
            // while (scanner.hasNextLine()) {
                // textF = textF + scanner.nextLine() + "\n";
            // }
            JSONRead json = new JSONRead();
            String[] a = json.readJSON(this.index);
            String textF = a[0];
            this.text.setText(textF);
        } catch (Exception e) {
            fin();
            this.fin = true;
        }
    }

    public void getImage(int index) {
        // this.image.setIcon(new ImageIcon("..\\data\\" + this.location + "\\" + this.index + ".png"));
        try {
            this.image.setIcon(new ImageIcon(new JSONRead().readJSON(this.index)[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        if (this.index == 0) {
            this.gui.getPrecedent().setEnabled(false);
        }
        this.fin = false;
    }

    public void fin() {
        this.text.setText("fin");
    }
}
