package view;

import control.GUIListener;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Diapositive diapo;
    private Menu menu;
    private Chrono chrono;

    private JPanel header;
    private JButton exit;
    private JLabel title;

    private JPanel footer;
    private JButton suivant;
    private JButton precedent;

    public GUI() {
        //GUI
        super("Titre ?");

        this.diapo = new Diapositive();
        this.menu = new Menu();

        this.chrono = new Chrono("../data/score.bin");

        this.setHeader();
        this.setFooter();
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
        this.footer.setVisible(false);
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
        this.footer.setVisible(true);
        this.precedent.setEnabled(false);
        repaint();
        pack();
    }

    /**
     * Initialise header with Title
     * @param string Window title
     */
    public void setHeader(String title){
        this.setTitle(title);
        this.header = new JPanel();
        if(title.equals("Menu")){
            this.exit.setText("close");
        } else {
            this.exit.setText("exit");
        }
        this.title.setText(title);
        repaint();
    }

    public void setFooter() {
        this.footer = new JPanel();
        this.suivant = new JButton("Suivant");
        this.precedent = new JButton("Précédent");
        this.footer.add(this.precedent);
        this.footer.add(this.suivant);
        add(this.footer,BorderLayout.SOUTH);
    }

    public void setHeader() {
        this.header = new JPanel(new BorderLayout());
        this.exit = new JButton(" ");
        this.title = new JLabel(" ");
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.exit.addActionListener(new GUIListener(this));
        this.header.add(this.exit,BorderLayout.WEST);
        this.header.add(this.title,BorderLayout.CENTER);
        add(this.header,BorderLayout.NORTH);
        setHeader("Menu");
    }
    public void precedentSetState(boolean state){
        this.precedent.setEnabled(state);
    }

    public void getChrono() {
      return this.chrono;
    }
}
