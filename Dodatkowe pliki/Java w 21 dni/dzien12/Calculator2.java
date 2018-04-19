/* Rozwiązanie dla rozdział 12., ćwiczenie 2. */

package com.java21days;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.UIManager.*;

public class Calculator2 extends JFrame implements ActionListener {
    JTextField one = new JTextField("0", 5);
    JButton plusOrMinus = new JButton("+");
    JTextField two = new JTextField("0", 5);
    JButton equals = new JButton("=");
    JLabel result = new JLabel("");

    public Calculator2() {
        super("Dodaj lub odejmij dwie liczby");
        setSize(400, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        plusOrMinus.addActionListener(this);
        equals.addActionListener(this);
        add(one);
        add(plusOrMinus);
        add(two);
        add(equals);
        add(result);
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

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == equals) {
            try {
                int value1 = Integer.parseInt(one.getText());
                int value2 = Integer.parseInt(two.getText());
                if (plusOrMinus.getText().equals("+")) {
                    result.setText("" + (value1 + value2));                
                } else {
                    result.setText("" + (value1 - value2));
                }
            } catch (NumberFormatException exc) {
                one.setText("0");
                two.setText("0");
                result.setText("0");
            }
        }
        if (evt.getSource() == plusOrMinus) {
            if (plusOrMinus.getText().equals("+")) {
                plusOrMinus.setText("-");
            } else {
                plusOrMinus.setText("+");
            }
        }
    }

    public static void main(String[] arguments) {
        Calculator2.setLookAndFeel();
        Calculator2 frame = new Calculator2();
    }
}
