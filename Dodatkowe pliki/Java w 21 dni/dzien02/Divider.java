/* Rozwiązanie dla rozdział 2., ćwiczenie 2. */
   
package com.java21days;

class Divider {
    public static void main(String[] arguments) {
        float number1 = 15;
        float number2 = 6;
        float result = number1 / number2;
        float remainder = number1 % number2;
        System.out.println(number1 + " dzielone przez " + number2);
        System.out.println("\nWynik\tReszta");
        System.out.println(result + "\t" + remainder);
    }
}
