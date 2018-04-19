/* Rozwiązanie dla rozdział 2., ćwiczenie 1. */
   
package com.java21days;

class Investor {
    public static void main(String[] arguments) {
        float total = 14000;
        System.out.println("Inwestycja początkowa: " + total + " zł");
        // Zwiększenie o 40 procent.
        total = total + (total * .4F);
        System.out.println("Po pierwszym roku: " + total + " zł");
        // Utrata 1 500 zł po pierszym roku.
        total = total - 1500F;
        System.out.println("Po dwóch latach: " + total + " zł");
        // Zwiększenie o 12 procent w trzecim roku.
        total = total + (total * .12F);
        System.out.println("Po trzech latach: " + total + " zł");
    }
}
