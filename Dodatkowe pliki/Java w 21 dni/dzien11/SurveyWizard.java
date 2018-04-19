package com.java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SurveyWizard extends JPanel implements ActionListener {
    int currentCard = 0;
    CardLayout cards = new CardLayout();
    SurveyPanel[] ask = new SurveyPanel[3];

    public SurveyWizard() {
        super();
        setSize(240, 140);
        setLayout(cards);
        // konfiguracja ankiety
        String question1 = "Jaka jest Twoja płeć?";
        String[] resp1 = { "kobieta", "mężczyzna", "nie powiem" };
        ask[0] = new SurveyPanel(question1, resp1, 2);
        String question2 = "Ile masz lat?";
        String[] resp2 = { "Poniżej 25", "25-34", "35-54",
            "Ponad 54" };
        ask[1] = new SurveyPanel(question2, resp2, 1);
        String question3 = "Jak często ćwiczysz w każdym tygodniu?";
        String[] resp3 = { "Nigdy", "1-3 razy", "Więcej niż 3" };
        ask[2] = new SurveyPanel(question3, resp3, 1);
        ask[2].setFinalQuestion(true);
        addListeners();
    }

    private void addListeners() {
        for (int i = 0; i < ask.length; i++) {
            ask[i].nextButton.addActionListener(this);
            ask[i].finalButton.addActionListener(this);
            add(ask[i], "Karta " + i);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        currentCard++;
        if (currentCard >= ask.length) {
            System.exit(0);
        }
        cards.show(this, "Karta " + currentCard);
    }
}

class SurveyPanel extends JPanel {
    JLabel question;
    JRadioButton[] response;
    JButton nextButton = new JButton("Dalej");
    JButton finalButton = new JButton("Zakończ");

    SurveyPanel(String ques, String[] resp, int def) {
        super();
        setSize(160, 110);
        question = new JLabel(ques);
        response = new JRadioButton[resp.length];
        JPanel sub1 = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JLabel quesLabel = new JLabel(ques);
        sub1.add(quesLabel);
        JPanel sub2 = new JPanel();
        for (int i = 0; i < resp.length; i++) {
            if (def == i) {
                response[i] = new JRadioButton(resp[i], true);
            } else {
                response[i] = new JRadioButton(resp[i], false);
            }
            group.add(response[i]);
            sub2.add(response[i]);
        }
        JPanel sub3 = new JPanel();
        nextButton.setEnabled(true);
        sub3.add(nextButton);
        finalButton.setEnabled(false);
        sub3.add(finalButton);
        GridLayout grid = new GridLayout(3, 1);
        setLayout(grid);
        add(sub1);
        add(sub2);
        add(sub3);
    }

    void setFinalQuestion(boolean finalQuestion) {
        if (finalQuestion) {
            nextButton.setEnabled(false);
            finalButton.setEnabled(true);
        }
    }
}
