package com.java21days;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class FeedInfo extends JFrame {
    private JLabel nameLabel = new JLabel("Nazwa: ",
        SwingConstants.RIGHT);
    private JTextField name;
    private JLabel urlLabel = new JLabel("URL: ",
        SwingConstants.RIGHT);
    private JTextField url;
    private JLabel typeLabel = new JLabel("Typ: ",
        SwingConstants.RIGHT);
    private JTextField type;

    public FeedInfo() {
        super("Informacje o źródle");
        setSize(400, 145);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        // nazwa witryny
        String response1 = JOptionPane.showInputDialog(null,
            "Wpisz nazwę witryny:");
        name = new JTextField(response1, 20);

        // adres witryny
        String response2 = JOptionPane.showInputDialog(null,
            "Wpisz adres witryny:");
        url = new JTextField(response2, 20);

        // typ witryny
        String[] choices = { "Osobista", "Komercyjna", "Inna" };
        int response3 = JOptionPane.showOptionDialog(null,
            "Jaki to typ witryny?",
            "Typ witryny",
            0,
            JOptionPane.QUESTION_MESSAGE,
            null,
            choices,
            choices[0]);
        type = new JTextField(choices[response3], 20);

        setLayout(new GridLayout(3, 2));
        add(nameLabel);
        add(name);
        add(urlLabel);
        add(url);
        add(typeLabel);
        add(type);
        setLookAndFeel();
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
        FeedInfo frame = new FeedInfo();
    }
}
