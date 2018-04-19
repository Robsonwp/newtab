package com.java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ClosureMayhem extends JFrame {
    JButton harry, wade, hansel;
     
    public ClosureMayhem() {
        super("Wybierz kursor");
        setLookAndFeel();
        setSize(400, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        harry = new JButton("Celownik");
        add(harry);
        wade = new JButton("Oczekiwanie");
        add(wade);
        hansel = new JButton("Rączka");
        add(hansel);
        // początek domknięcia
        ActionListener act = (event) -> {
            if (event.getSource() == harry) {
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            }
            if (event.getSource() == wade) {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
            }
            if (event.getSource() == hansel) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        };
        // koniec domknięcia
        harry.addActionListener(act);
        wade.addActionListener(act);
        hansel.addActionListener(act);
        setVisible(true);
    }
  
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.err.println("Błąd wyglądu: " + exc);
        }
    }
     
    public static void main(String[] arguments) {
        new ClosureMayhem();
    }
}
