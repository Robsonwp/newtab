package com.java21days;

import java.awt.*;
import javax.swing.*;

public class Stacker extends JFrame {
    public Stacker() {
        super("Stacker");
        setSize(430, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        // utwórz górny panel
        JPanel commandPane = new JPanel();
        BoxLayout horizontal = new BoxLayout(commandPane,
            BoxLayout.X_AXIS);
        commandPane.setLayout(horizontal);
        JButton subscribe = new JButton("Subskrybuj");
        JButton unsubscribe = new JButton("Anuluj subskrypcję");
        JButton refresh = new JButton("Odśwież");
        JButton save = new JButton("Zapisz");
        commandPane.add(subscribe);
        commandPane.add(unsubscribe);
        commandPane.add(refresh);
        commandPane.add(save);
        // utwórz dolny panel
        JPanel textPane = new JPanel();
        JTextArea text = new JTextArea(4, 70);
        JScrollPane scrollPane = new JScrollPane(text);
        // połączenie ich razem
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(commandPane);
        add(scrollPane);
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
        Stacker st = new Stacker();
    }
}
