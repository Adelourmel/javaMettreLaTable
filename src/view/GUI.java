package view;

import control.DiapositiveListener;
import control.GUIListener;
import model.*;

import javax.swing.*;
import java.awt.*;

/**
 * This class make the graphical user interface.
 */
public class GUI extends JFrame {
    /**
     * The Diapositive JPanel.
     */
    private Diapositive diapo;
    /**
     * The menu JPanel.
     */
    private Menu menu;
    /**
     * The Chrono og the application.
     */
    private Chrono chrono;

    /**
     * The GUI header.
     */
    private JPanel header;
    /**
     * The close and exit diapositive button.
     */
    private JButton exit;
    /**
     * The Header title.
     */
    private JLabel title;
    /**
     * The progression bar of the diapositive.
     */
    private JProgressBar progressBar;

    private JPanel footer;
    private JButton suivant;
    private JButton precedent;

    private final Color green_color = new Color(104, 159, 56);
    private final Color yellow_color = new Color(255, 193, 7);

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
     * @param title The diapo title.
     * @param directory The diapo file directory for content.
     */
    public void showDiapo(String title) {
        setHeader(title);
        this.diapo = new Diapositive(this, title);
        add(this.diapo);
        remove(this.menu);
        this.footer.setVisible(true);
        this.precedent.setEnabled(false);
        repaint();
    }

    /**
     * Initialize header with title
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

    /**
     * Make footer panel.
     */
    private void setFooter() {
        this.footer = new JPanel(new GridLayout(1, 2));
        this.suivant = new JButton("<html><font size=15 color = white>Suivant</font></html>");
        this.precedent = new JButton("<html><font size=15 color = white >Précédent</font></html>");
        this.suivant.setBackground(green_color);
        this.precedent.setBackground(green_color);
        this.precedent.addActionListener(new DiapositiveListener(this));
        this.suivant.addActionListener(new DiapositiveListener(this));

        this.footer.add(this.precedent);
        this.footer.add(this.suivant);
        add(this.footer, BorderLayout.SOUTH);
    }

    /**
     * Make the header panel.
     */
    private void setHeader() {
        this.header = new JPanel(new BorderLayout());
        this.header.setBackground(green_color);
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
        this.progressBar.setForeground(yellow_color);
        this.header.add(this.exit, BorderLayout.WEST);
        this.header.add(this.title, BorderLayout.CENTER);
        this.header.add(this.progressBar, BorderLayout.SOUTH);
        add(this.header, BorderLayout.NORTH);
        setHeader("Menu");
    }

    /**
     * Get the Header title.
     * @return The header title.
     */
    public String getTitle() {
        return title.getText();
    }

    /**
     * Get the application chrono.
     * @return The application chrono.
     */
    public Chrono getChrono() {
        return this.chrono;
    }

    /**
     * Return the menu panel.
     * @return The menu panel.
     */
    public Menu getMenu() {
        return this.menu;
    }

    /**
     * Get the next button.
     * @return The next button.
     */
    public JButton getSuivant() {
        return suivant;
    }

    /**
     * Get the previous button.
     * @return The previous button.
     */
    public JButton getPrecedent() {
        return precedent;
    }

    /**
     * Get the diapositive panel.
     * @return The diapositive panel.
     */
    public Diapositive getDiapo() {
        return diapo;
    }

    /**
     * Get the progress bar.
     * @return The progress bar.
     */
    public JProgressBar getProgressBar() {
        return progressBar;
    }
}
