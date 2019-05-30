package view;

import control.GUIListener;
import model.*;

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
        this.chrono = new Chrono("../data/score.bin");
        this.menu = new Menu(this.chrono);

        this.setHeader();
        this.setFooter();
        // GUI configuration.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,500));
        setMinimumSize(new Dimension(800,500));
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
    }

    /**
     * Allow to show the diapo
     *
     * @param nbSlide The slide number you want to show
     */
    public void showDiapo(int nbSlide, String title) {
        setHeader(title);
        this.diapo = new Diapositive(nbSlide, title);
        add(this.diapo);
        remove(this.menu);
        this.footer.setVisible(true);
        this.precedentSetState(false);
        repaint();
    }

    /**
     * Initialise header with Title
     *
     * @param title Window title
     */
    public void setHeader(String title) {
        this.setTitle(title);
        this.header = new JPanel();
        if (title.equals("Menu")) {
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/source/ButtonIcone/close.png");
            this.exit.setIcon(icon);
        } else {
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/source/ButtonIcone/return.png");
            this.exit.setIcon(icon);
        }
        this.title.setText("<html><font size=15 color = white >" + title + "</font></html>");
        repaint();
    }

    public void setFooter() {
        this.footer = new JPanel(new GridLayout(1, 2));
        this.suivant = new JButton("<html><font size=15 color = white>Suivant</font></html>");
        this.precedent = new JButton("<html><font size=15 color = white >Précédent</font></html>");
        this.suivant.setBackground(new Color(104, 159, 56));
        this.precedent.setBackground(new Color(104, 159, 56));

        this.footer.add(this.precedent);
        this.footer.add(this.suivant);
        add(this.footer, BorderLayout.SOUTH);
    }

    public void setHeader() {
        this.header = new JPanel(new BorderLayout());
        this.header.setBackground(new Color(104, 159, 56));
        this.exit = new JButton();
        this.exit.setPreferredSize(new Dimension(50, 50));
        this.exit.setBackground(null);
        this.exit.setBorderPainted(false);
        this.exit.setFocusPainted(false);
        this.exit.setContentAreaFilled(false);
        this.title = new JLabel();
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.exit.addActionListener(new GUIListener(this));
        this.header.add(this.exit, BorderLayout.WEST);
        this.header.add(this.title, BorderLayout.CENTER);
        add(this.header, BorderLayout.NORTH);
        setHeader("Menu");
    }

    public void precedentSetState(boolean state) {
        this.precedent.setEnabled(state);
    }

    public String getTitle() {
        return title.getText();
    }

    public Chrono getChrono() {
      return this.chrono;
    }
}
