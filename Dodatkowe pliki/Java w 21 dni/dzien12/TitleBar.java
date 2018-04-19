package com.java21days;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TitleBar extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;

    public TitleBar() {
        super("Pasek tytułu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        b1 = new JButton("Rosenkrantz");
        b2 = new JButton("Guildenstern");
        b1.addActionListener(this);
        b2.addActionListener(this);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(b1);
        add(b2);
        pack();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == b1) {
            setTitle("Rosenkrantz");
        } else if (source == b2) {
            setTitle("Guildenstern");
        }
        repaint();
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
        TitleBar frame = new TitleBar();
    }
}
