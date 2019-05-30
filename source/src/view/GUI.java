package view;

import control.GUIListener;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Diapositive diapo;
    private Menu menu;

    private JPanel header;
    private JButton exit;
    private JLabel title;

    public GUI() {
        //GUI
        super("Titre ?");

        this.diapo = new Diapositive();
        this.menu = new Menu();
        //header
        this.header = new JPanel();
        this.exit = new JButton(" ");
        this.title = new JLabel(" ");
        this.exit.addActionListener(new GUIListener(this));
        this.header.add(this.exit);
        this.header.add(this.title);
        add(this.header,BorderLayout.NORTH);
        setHeader("Menu");

        // GUI configuration.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * Allow to show the menu
     */
    public void showMenu() {
        setHeader("Menu");
        remove(this.diapo);
        add(this.menu);
        repaint();
        pack();
    }

    /**
     * Allow to show the diapo
     *
     * @param nbSlide The slide number you want to show
     */
    public void showDiapo(int nbSlide,String title) {
        setHeader(title);
        this.diapo=new Diapositive(nbSlide,title);
        add(this.diapo);
        remove(this.menu);
        repaint();
        pack();
    }

    /**
     * Initialise header with Title
     * @param string
     */
    public void setHeader(String title){
        this.header = new JPanel();
        if(title.equals("Menu")){
            this.exit.setText("close");
        } else {
            this.exit.setText("exit");
        }
        this.title.setText(title);
        repaint();
    }
}
