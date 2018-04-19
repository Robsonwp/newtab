package com.java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyChecker2 extends JFrame {
    JLabel keyLabel = new JLabel("Naciśnij dowolny klawisz");

    public KeyChecker2() {
        super("Naciśnij klawisz");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        KeyAdapter monitor = new KeyAdapter() {
            public void keyTyped(KeyEvent event) {
                keyLabel.setText("" + event.getKeyChar());
                repaint();
            }
        };
        setFocusable(true);
        addKeyListener(monitor);
        add(keyLabel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
             System.err.println("Nie potrafię wczytać "
                + "systemowego wyglądu: " + exc);
        }
    } 

    public static void main(String[] arguments) {
        KeyChecker2.setLookAndFeel();
        new KeyChecker2();
    }
}
