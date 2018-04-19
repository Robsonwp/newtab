package com.java21days;

import javax.swing.*;

public class Authenticator2 extends javax.swing.JFrame {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextArea comments = new JTextArea(4, 15);
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Anuluj");

    public Authenticator2() {
        super("Informacje o koncie");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel ();
        JTextArea comments = new JTextArea(4, 15);
        JScrollPane scroll = new JScrollPane(comments,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.add(scroll);
        add(pane);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nie mogłem użyć systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] arguments) {
        Authenticator2.setLookAndFeel();
        Authenticator2 auth = new Authenticator2();
    }
}
