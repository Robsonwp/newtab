/* Rozwiązanie dla rozdział 8., ćwiczenie 1. */

package com.java21days;

import java.util.*;

public class ComicBooks2 {

    public ComicBooks2() {
    }

    public static void main(String[] arguments) {
        // ustawienie obiektu HashMap
        HashMap quality = new HashMap();
        quality.put("całkowicie nowy", 5.00F);
        quality.put("jak nowy", 3.00F);
        quality.put("prawie jak nowy", 2.00F);
        quality.put("bardzo dobry", 1.50F);
        quality.put("dobry", 1.00F);
        quality.put("średni", 0.50F);
        quality.put("słaby", 0.25F);
        quality.put("bez okładki", 0.10F);
        // konfiguracja kolekcji
        Comic[] comix = new Comic[5];
        comix[0] = new Comic("Wspaniały Spider-Man", "1A", "bardzo dobry",
            5_000.00F);
        comix[0].setPrice( (Float) quality.get(comix[0].condition) );
        comix[1] = new Comic("Niesamowity Hulk", "181", "prawie jak nowy",
            240.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition) );
        comix[2] = new Comic("Cerebus", "1A", "średni", 144.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition) );
        comix[3] = new Comic("Prez", "1", "całkowicie nowy", 30.00F);
        comix[3].setPrice( (Float)quality.get(comix[3].condition) );
        comix[4] = new Comic("Nocna pielęgniarka", "1", "bez okładki", 22.00F);
        comix[4].setPrice( (Float)quality.get(comix[4].condition) );
        for (Comic comix1 : comix) {
            System.out.println("Tytuł: " + comix1.title);
            System.out.println("Numer: " + comix1.issueNumber);
            System.out.println("Stan: " + comix1.condition);
            System.out.println("Cena: " + comix1.price + "zł\n");
        }
    }
}
