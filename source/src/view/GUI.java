package view;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Diapositive diapo;
    private Menu menu;
    private JPanel header;
    private JButton exit;

    public GUI() {
        super("Titre ?");

        this.diapo = new Diapositive();
        this.menu = new Menu();

        setHeader("Menu");
        add(this.header,BorderLayout.NORTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }

    /**
     * Allow to show the menu
     */
    public void showMenu() {
        setHeader("Menu");
        add(this.menu);
        remove(this.diapo);
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

    public void setHeader(String string){
        this.header = new JPanel();
        if(string.equals("Menu")){
            this.exit = new JButton("close");
        } else {
            this.exit = new JButton("exit");
        }
        this.header.add(this.exit);
        this.header.add(new JLabel(string));
    }
}
