package com.java21days;

import javax.swing.*;

public class Slider extends JFrame {

    public Slider() {
        super("Suwak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JSlider pick = new JSlider(JSlider.HORIZONTAL, 0, 30, 5);
        pick.setMajorTickSpacing(10);
        pick.setMinorTickSpacing(1);
        pick.setPaintTicks(true);
        pick.setPaintLabels(true);
        add(pick);
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
        Slider frame = new Slider();
    }
}
