package com.java21days;

import java.awt.*;
import javax.swing.*;

public class Border extends JFrame {

    public Border() {
        super("Border");
        setSize(240, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setLayout(new BorderLayout());
        JButton nButton = new JButton("Północ");
        JButton sButton = new JButton("Południe");
        JButton eButton = new JButton("Wschód");
        JButton wButton = new JButton("Zachód");
        JButton cButton = new JButton("Środek");
        add(nButton, BorderLayout.NORTH);
        add(sButton, BorderLayout.SOUTH);
        add(eButton, BorderLayout.EAST);
        add(wButton, BorderLayout.WEST);
        add(cButton, BorderLayout.CENTER);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
            System.err.println("Nie potrafię wczytać "
                + "systemowego wyglądu: " + exc);
        }
    }

    public static void main(String[] arguments) {
        Border frame = new Border();
    }
}
