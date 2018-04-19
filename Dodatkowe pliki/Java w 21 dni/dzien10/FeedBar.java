package com.java21days;

import java.awt.*;
import javax.swing.*;

public class FeedBar extends JFrame {

    public FeedBar() {
        super("Pasek narzędziowy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        // utworzenie ikon
        ImageIcon loadIcon = new ImageIcon("load.gif");
        ImageIcon saveIcon = new ImageIcon("save.gif");
        ImageIcon subIcon = new ImageIcon("subscribe.gif");
        ImageIcon unsubIcon = new ImageIcon("unsubscribe.gif");
        // utworzenie przycisków
        JButton load = new JButton("Wczytaj", loadIcon);
        JButton save = new JButton("Zapisz", saveIcon);
        JButton sub = new JButton("Zarejestruj", subIcon);
        JButton unsub = new JButton("Wyrejestruj", unsubIcon);
        // dodanie przycisków do paska narzędziowego
        JToolBar bar = new JToolBar();
        bar.add(load);
        bar.add(save);
        bar.add(sub);
        bar.add(unsub);
        // przygotuj interfejs użytkownika
        JTextArea edit = new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add("South", bar);
        add("Center", scroll);
        pack();
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                + "systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] arguments) {
        FeedBar frame = new FeedBar();
    }
}
