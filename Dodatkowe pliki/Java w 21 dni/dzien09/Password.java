/* Rozwiązanie dla rozdział 9., ćwiczenie 2. */

package com.java21days;

import javax.swing.*;

public class Password extends JFrame {
    PasswordFrame pass = new PasswordFrame();
    
    public Password() {
        super("Poproś o hasło");
        setSize(540, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pass.setVisible(true);
}

    public static void main(String[] arguments) {
        Password ask = new Password();
    }
}

class PasswordFrame extends JFrame {
    public PasswordFrame() {
        super("Hasło");
        setSize(210, 130);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel usernameLabel = new JLabel("Nazwa użytkownika: ");
        JTextField username = new JTextField(8);
        JLabel passwordLabel = new JLabel("Hasło: ");
        JPasswordField password = new JPasswordField(8);
        pane.add(usernameLabel);
        pane.add(username);
        pane.add(passwordLabel);
        pane.add(password);
        setContentPane(pane);
        setVisible(false);
    }
}
