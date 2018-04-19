package com.java21days;

import javax.swing.*;

public class ButtonFrame extends JFrame {
    JButton load = new JButton("Wczytaj");
    JButton save = new JButton("Zapisz");
    JButton unsubscribe = new JButton("Wyrejestruj");

    public ButtonFrame() {
        super("Ramka z przyciskami");
        setSize(340, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.add(load);
        pane.add(save);
        pane.add(unsubscribe);
        add(pane);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] arguments) {
        setLookAndFeel();
        ButtonFrame bf = new ButtonFrame();
    }
}
