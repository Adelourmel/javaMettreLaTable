package view;

import control.DiapositiveListener;
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
    private JProgressBar progressBar;

    private JPanel footer;
    private JButton suivant;
    private JButton precedent;

    public GUI() {
        //GUI
        super("Mettre la table :D");

        this.diapo = new Diapositive();
        this.chrono = new Chrono("data/score.bin");

        this.setHeader();
        this.setFooter();
        // GUI configuration.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        setMinimumSize(new Dimension(800, 500));
        pack();
        showMenu();
        setVisible(true);
    }

    /**
     * Allow to show the menu
     */
    public void showMenu() {
        setHeader("Menu");
        remove(this.diapo);
        this.menu = new Menu(this);
        add(this.menu);
        this.footer.setVisible(false);
        repaint();
    }

    /**
     * Allow to show the diapo
     *
     * @param title
     * @param directory
     */
    public void showDiapo(String title, String directory) {
        setHeader(title);
        this.diapo = new Diapositive(this, title, directory);
        add(this.diapo);
        remove(this.menu);
        this.footer.setVisible(true);
        this.precedent.setEnabled(false);
        repaint();
    }

    /**
     * Initialise header with Title
     *
     * @param title Window title
     */
    private void setHeader(String title) {
        this.setTitle(title);
        this.header = new JPanel();
        if (title.equals("Menu")) {
            ImageIcon icon = new ImageIcon("data/buttonsIcons/close.png");
            this.exit.setIcon(icon);
            this.progressBar.setVisible(false);
        } else {
            ImageIcon icon = new ImageIcon("data/buttonsIcons/return.png");
            this.exit.setIcon(icon);
            this.progressBar.setVisible(true);
        }
        this.title.setText("<html><font size=15 color = white >" + title + "</font></html>");
        repaint();
    }

    private void setFooter() {
        this.footer = new JPanel(new GridLayout(1, 2));
        this.suivant = new JButton("<html><font size=15 color = white>Suivant</font></html>");
        this.precedent = new JButton("<html><font size=15 color = white >Précédent</font></html>");
        this.suivant.setBackground(new Color(104, 159, 56));
        this.precedent.setBackground(new Color(104, 159, 56));
        this.precedent.addActionListener(new DiapositiveListener(this));
        this.suivant.addActionListener(new DiapositiveListener(this));

        this.footer.add(this.precedent);
        this.footer.add(this.suivant);
        add(this.footer, BorderLayout.SOUTH);
    }

    private void setHeader() {
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
        this.progressBar = new JProgressBar();
        this.progressBar.setForeground(new Color(255, 193, 7));
        this.header.add(this.exit, BorderLayout.WEST);
        this.header.add(this.title, BorderLayout.CENTER);
        this.header.add(this.progressBar, BorderLayout.SOUTH);
        add(this.header, BorderLayout.NORTH);
        setHeader("Menu");
    }

    public String getTitle() {
        return title.getText();
    }

    public Chrono getChrono() {
        return this.chrono;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public JButton getSuivant() {
        return suivant;
    }

    public JButton getPrecedent() {
        return precedent;
    }

    public Diapositive getDiapo() {
        return diapo;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }
}
