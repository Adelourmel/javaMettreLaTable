package view;

import javax.swing.*;

public class GUI extends JFrame {

    private Diapositive diapo;
    private Menu menu;

    public GUI() {
        super("Titre ?");

        this.diapo = new Diapositive();
        this.menu = new Menu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }

    /**
     * Allow to show the menu
     */
    public void showMenu() {
        add(this.menu);
        remove(this.diapo);
    }

    /**
     * Allow to show the diapo
     *
     * @param nbSlide The slide number you want to show
     */
    public void showDiapo(int nbSlide,String title) {
        this.diapo=new Diapositive(nbSlide,title);
        add(this.diapo);
        remove(this.menu);
    }
}
