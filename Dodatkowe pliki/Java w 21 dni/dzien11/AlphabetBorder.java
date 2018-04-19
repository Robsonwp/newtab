/* Rozwiązanie dla rozdział 11., ćwiczenie 2. */

package com.java21days;

import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;

class AlphabetBorder extends JFrame {
    JButton north = new JButton("Północ");
    JButton south = new JButton("Południe");
    JButton east = new JButton("Wschód");
    JButton west = new JButton("Zachód");
    AlphabetPanel alpha = new AlphabetPanel();

    AlphabetBorder() {
        super("AlphabetBorder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(240, 300);
        setLayout(new BorderLayout());
        add("North", north);
        add("South", south);
        add("East", east);
        add("West", west);
        add("Center", alpha);
        setVisible(true);
    }
    
    private static void setLookAndFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                + "systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] arguments) {
        AlphabetBorder.setLookAndFeel();
        JFrame frame = new AlphabetBorder();
    }
}

class AlphabetPanel extends JPanel {
    JButton a = new JButton("Alibi");
    JButton b = new JButton("Biurko");
    JButton c = new JButton("Ciało");
    JButton d = new JButton("Dowód");
    JButton e = new JButton("Ekran");
    JButton f = new JButton("Fasada");
    
    AlphabetPanel() {
        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
        setLayout(lm);
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);
    }

}
