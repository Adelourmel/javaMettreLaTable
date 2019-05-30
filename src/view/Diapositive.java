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
    private JLabel text;

    public Diapositive() {
        super(new GridLayout(1, 2));
        this.index = 0;
    }

    public Diapositive(String title, String location) {
        super(new GridLayout(1, 2));
        this.title = title;
        this.location = location;
        this.index = 0;
        getText(this.index);//test normal si erreur il y a
    }

    public void getContent(int index) {
        getText(index);
        getImage(index);
    }

    public void getText(int index) {
        try {
            FileReader fr = new FileReader("..\\data\\"+this.location + "\\" + this.index + ".txt");
            Scanner scanner = new Scanner(fr);
            String text = "";
            while (scanner.hasNextLine()) {
                text += scanner.nextLine()+"\n";
            }
            this.text.setText(text);

            this.text.setText(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getImage(int index) {
        this.text.setIcon(new ImageIcon("..\\data\\"+this.location + "\\" + this.index + ".txt"));
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
