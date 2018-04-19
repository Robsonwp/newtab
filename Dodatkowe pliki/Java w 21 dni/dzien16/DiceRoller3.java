/* Rozwiązanie dla rozdział 16., ćwiczenie 2. */

package com.java21days;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class DiceRoller3 extends JFrame {

    // tablica wyników rzutów kostką
    JTextField[] total = new JTextField[16];
    // przycisk "Rzuć"
    JButton roll;
    // liczba rzutów
    JTextField quantity;
    // zadanie robocze Swing
    class DiceWorker extends SwingWorker {
        int timesToRoll;

        // konfiguracja zadania roboczego
        DiceWorker(int timesToRoll) {
            super();
            this.timesToRoll = timesToRoll;
        }

        // zdefiniuj zadanie wykonywane przez element roboczy
        protected int[] doInBackground() {
            int[] result = new int[16];
            for (int i = 0; i < timesToRoll; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += Math.floor(Math.random() * 6);
                }
                result[sum] = result[sum] + 1;
            }
            // przekaż wynik
            return result;
        }
    }
    DiceRoller3.DiceWorker worker;

    public DiceRoller3() {
        super("Rzucanie kostką 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(850, 145);

        // konfiguracja górnego wiersza
        JPanel topPane = new JPanel();
        GridLayout paneGrid = new GridLayout(1, 16);
        topPane.setLayout(paneGrid);
        for (int i = 0; i < 16; i++) {
            // utworzenie pola tekstowego i etykiety
            total[i] = new JTextField("0", 4);
            JLabel label = new JLabel((i + 3) + ": ");
            // utworzenie komórki w siatce
            JPanel cell = new JPanel();
            cell.add(label);
            cell.add(total[i]);
            // dodaj komórkę do górnego wiersza
            topPane.add(cell);
        }

        // konfiguracja dolnego wiersza
        JPanel bottomPane = new JPanel();
        JLabel quantityLabel = new JLabel("Liczba rzutów: ");
        quantity = new JTextField("0", 5);
        roll = new JButton("Rzuć");
        // odpowiedz, gdy zadanie robocze zakończy pracę
        PropertyChangeListener prop = (event) -> {
            try {
                // pobierz wynik rzutu kostką
                int[] result = (int[]) worker.get();
                // zapamiętaj wyniki w polach tekstowych
                for (int i = 0; i < result.length; i++) {
                    total[i].setText("" + result[i]);
                }
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        };
        ActionListener act = (event) -> {
            int timesToRoll;
            try {
                // wyłącz przycisk
                timesToRoll = Integer.parseInt(quantity.getText());
                roll.setEnabled(false);
                // skonfiguruj zadanie robocze, które rzuci kostkę
                worker = new DiceWorker(timesToRoll);
                // dodaj się jako obiekt nasłuchujący, który będzie monitorował zadanie robocze
                worker.addPropertyChangeListener(prop);
                // uruchom zadanie robocze
                worker.execute();
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        };
        roll.addActionListener(act);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);

        // konfiguracja ramki
        GridLayout frameGrid = new GridLayout(2, 1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);

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
            System.out.println("Błąd wyglądu: " + e);
        }
    }

    public static void main(String[] arguments) {
        DiceRoller3.setLookAndFeel();
        new DiceRoller3();
    }
}
