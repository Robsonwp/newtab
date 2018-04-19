/* Rozwiązanie dla rozdział 10., ćwiczenie 2. */

package com.java21days;

import javax.swing.*;

public class TitleFrame extends JFrame {
    public TitleFrame() {
        super("Ramka z tytułem");
        setLookAndFeel();
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String response = JOptionPane.showInputDialog(null,
            "Wpisz tytuł ramki:");
        setTitle(response);
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
        JFrame frame = new TitleFrame();
    }
}
