package com.java21days;

import javax.swing.*;

public class SimpleFrame extends JFrame {
    public SimpleFrame() {
        super("Tytuł ramki");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // zignoruj błąd
        }
    }

    public static void main(String[] arguments) {
        setLookAndFeel();
        SimpleFrame sf = new SimpleFrame();
    }
}
