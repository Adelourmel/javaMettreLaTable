package view;

import model.JSONRead;

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
        super(new GridLayout(3, 1));
        this.index = 0;
    }

    public void getContent(int index) {
        getText(index);
        getImage(index);
    }

    public void getText(int index) {
        try {
            FileReader fr = new FileReader(this.location+"/"+this.index+".txt");
            String text = fr.read();
            this.text.setText(text);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getImage(int index) {
        this.text.setIcon(new ImageIcon(this.location+"/"+this.index+".png"));
    }

    public void getNext(){
        this.index ++;
        getContent(this.index);
    }

    public void getPrevious(){
        this.index --;
        getContent(this.index);
    }
}
