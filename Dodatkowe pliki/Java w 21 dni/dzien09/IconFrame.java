package com.java21days;

import javax.swing.*;

public class IconFrame extends JFrame {
    JButton load, save, subscribe, unsubscribe;

    public IconFrame() {
        super("Ramka ikony");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        // utwórz ikony
        ImageIcon loadIcon = new ImageIcon("load.gif");
        ImageIcon saveIcon = new ImageIcon("save.gif");
        ImageIcon subscribeIcon = new ImageIcon("subscribe.gif");
        ImageIcon unsubscribeIcon = new ImageIcon("unsubscribe.gif");
        // utwórz przyciski
        load = new JButton("Wczytaj", loadIcon);
        save = new JButton("Zapisz", saveIcon);
        subscribe = new JButton("Zarejestruj", subscribeIcon);
        unsubscribe = new JButton("Wyrejestruj", unsubscribeIcon);
        // dodaj przyciski do panelu
        panel.add(load);
        panel.add(save);
        panel.add(subscribe);
        panel.add(unsubscribe);
        // dodaj panel do ramki
        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        IconFrame ike = new IconFrame();
    }
}
