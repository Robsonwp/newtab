/* Rozwiązanie dla rozdział 3., ćwiczenie 1. */

package com.java21days;

class Birthday {
    public static void main(String[] arguments) {
        String birthday = "29/04/2016";
        String day = birthday.substring(0, 2);
        String month = birthday.substring(3, 5);
        String year = birthday.substring(6, 10);
        System.out.println("Urodziny: " + birthday);
        System.out.println("Dzień: " + day);
        System.out.println("Miesiąc: " + month);
        System.out.println("Rok: " + year);
    }
}

