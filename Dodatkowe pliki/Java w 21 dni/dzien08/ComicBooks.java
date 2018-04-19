package com.java21days;

import java.util.*;

public class ComicBooks {

    public ComicBooks() {
    }

    public static void main(String[] arguments) {
        // ustawienie obiektu HashMap
        HashMap quality = new HashMap();
        float price1 = 3.00F;
        quality.put("jak nowy", price1);
        float price2 = 2.00F;
        quality.put("prawie jak nowy", price2);
        float price3 = 1.50F;
        quality.put("bardzo dobry", price3);
        float price4 = 1.00F;
        quality.put("dobry", price4);
        float price5 = 0.50F;
        quality.put("średni", price5);
        float price6 = 0.25F;
        quality.put("słaby", price6);
        // konfiguracja kolekcji
        Comic[] comix = new Comic[3];
        comix[0] = new Comic("Wspaniały Spider-Man", "1A", "bardzo dobry",
            12_000.00F);
        comix[0].setPrice( (Float) quality.get(comix[0].condition) );
        comix[1] = new Comic("Niesamowity Hulk", "181", "prawie jak nowy",
            680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition) );
        comix[2] = new Comic("Cerebus", "1A", "średni", 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition) );
        for (int i = 0; i < comix.length; i++) {
            System.out.println("Tytuł: " + comix[i].title);
            System.out.println("Numer: " + comix[i].issueNumber);
            System.out.println("Stan: " + comix[i].condition);
            System.out.println("Cena: " + comix[i].price + "zł\n");
        }
    }
}

class Comic {
    String title;
    String issueNumber;
    String condition;
    float basePrice;
    float price;

    Comic(String inTitle, String inIssueNumber, String inCondition,
        float inBasePrice) {

        title = inTitle;
        issueNumber = inIssueNumber;
        condition = inCondition;
        basePrice = inBasePrice;
    }

    void setPrice(float factor) {
        price = basePrice * factor;
    }
}
