package com.java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bunch extends JFrame {

    public Bunch() {
        super("Bunch");
        setSize(260, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JPanel pane = new JPanel();
        GridLayout family = new GridLayout(3, 3, 10, 10);
        pane.setLayout(family);
        JButton marcia = new JButton("Marcia");
        JButton carol = new JButton("Karol");
        JButton greg = new JButton("Grzegorz");
        JButton jan = new JButton("Jan");
        JButton alice = new JButton("Alicja");
        JButton peter = new JButton("Piotr");
        JButton cindy = new JButton("Cindy");
        JButton mike = new JButton("Michał");
        JButton bobby = new JButton("Robert");
        pane.add(marcia);
        pane.add(carol);
        pane.add(greg);
        pane.add(jan);
        pane.add(alice);
        pane.add(peter);
        pane.add(cindy);
        pane.add(mike);
        pane.add(bobby);
        add(pane);
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
        Bunch frame = new Bunch();
    }
}
