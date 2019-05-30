package view;

import model.JSONRead;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class Diapositive extends JPanel {
    private int index;
    private String title;
    private String location;
    private String desc;

    private JLabel image;
    private JTextArea text;

    public Diapositive() {
        super(new GridLayout(1, 2));
        this.index = 0;
    }

    public Diapositive(String title, String location) {
        super(new GridLayout(1, 2));
        this.text = new JTextArea();
        this.image = new JLabel();
        add(text);
        add(image);
        this.title = title;
        this.location = location;
        this.index = 0;
        getContent(this.index);
    }

    public void getContent(int index) {
        getText(index);
        getImage(index);
    }

    public void getText(int index) {
        try {
            FileReader fr = new FileReader(this.location + "\\" + this.index + ".txt");
            Scanner scanner = new Scanner(fr);
            String textF = "";
            while (scanner.hasNextLine()) {
                textF = textF + scanner.nextLine() + "\n";
            }
            this.text.setText(textF);
        } catch (Exception e) {
            System.out.println("erreur :" + e);
        }
    }

    public void getImage(int index) {
        this.image.setIcon(new ImageIcon("..\\data\\" + this.location + "\\" + this.index + ".png"));
    }

    public void getNext() {
        this.index++;
        getContent(this.index);
    }

    public void getPrevious() {
        this.index--;
        getContent(this.index);
    }
}
