/* Rozwiązanie dla rozdział 13., ćwiczenie 1. */

package com.java21days;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.UIManager.*;

/* Aplikacja wymaga czterech argumentów: promieć, położenie x,
   położenie y i kolor w formacie jak dla stron WWW. Na przykład
   argumenty 100 9,17 #FF0000 narysują okrąg o promieniu 100 w położeniu (9,17)
   i kolorze #FF0000 (czerwony). */
public class Circle extends JFrame {
    public Circle(String argR, String argX, String argY, String argColor) {
        super("Circle");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CirclePanel cp = new CirclePanel(argR, argX, argY, argColor);
        add(cp);
        setVisible(true);
    }
    
    public static void main(String[] arguments) {
        if (arguments.length < 3) {
            System.out.println("Użycie: java Circle promień x y kolor");
            System.exit(0);
        } else {
            Circle dc = new Circle(arguments[0], arguments[1],
                arguments[2], arguments[3]);
        }
    }
}

class CirclePanel extends JPanel {
    int radius, x, y;
    Color color;

    public CirclePanel(String inRadius, String inX, String inY, String inColor) {
        super();
        if (inRadius == null) {
            radius = 100;
        }
        if (inX == null) {
            x = 110;
        }
        if (inY == null) {
            y = 110;
        }
        if (inColor == null) {
            color = Color.blue;
        }
        try {
            radius = Integer.parseInt(inRadius);
            x = Integer.parseInt(inX);
            y = Integer.parseInt(inY);
            color = Color.decode(inColor);
        } catch (NumberFormatException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.white);
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
        comp2D.setColor(color);
        Ellipse2D.Float circle = new Ellipse2D.Float(x, y, radius, radius);
        comp2D.fill(circle);
    }
}