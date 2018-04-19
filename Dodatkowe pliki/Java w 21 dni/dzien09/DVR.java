/* Rozwiązanie dla rozdział 9., ćwiczenie 1. */

package com.java21days;

import javax.swing.*;

public class DVR extends JFrame {
    JButton play = new JButton("Odtwarzanie");
    JButton stopEject = new JButton("Stop/Wysuń");
    JButton rewind = new JButton("Przewiń w tył");
    JButton fastForward = new JButton("Przewiń w przód");
    JButton pause = new JButton("Pauza");
    
    public DVR() {
        super("Nagrywarka");
        setSize(540, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.add(play);
        pane.add(stopEject);
        pane.add(rewind);
        pane.add(fastForward);
        pane.add(pause);
        setContentPane(pane);
        setVisible(true);
}

    public static void main(String[] arguments) {
        DVR dvr = new DVR();
    }
}
