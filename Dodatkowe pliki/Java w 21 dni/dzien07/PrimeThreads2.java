/* Rozwiązanie dla rozdział 7., ćwiczenie 2. */

package com.java21days;

public class PrimeThreads2 {
    public static void main(String[] arguments) {
        try {
            PrimeFinder2[] finder = new PrimeFinder2[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                long count = Long.parseLong(arguments[i]);
                finder[i] = new PrimeFinder2(count);
                System.out.println("Szukam liczby pierwszej " + count);
            }
            boolean complete = false;
            while (!complete) {
                complete = true;
                for (int j = 0; j < finder.length; j++) {
                    if (!finder[j].finished)
                        complete = false;
                }    
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    // nic nie rób
                }
            }
            for (int j = 0; j < finder.length; j++) {
                System.out.println("Liczba pierwsza " + finder[j].target
                    + " to " + finder[j].prime);
            }    
        } catch (NumberFormatException nfe) {
                System.out.println("Błąd: " + nfe.getMessage());
        } catch (NegativeNumberException nne) {
                System.out.println("Błąd: " + nne.getMessage());
        }
    }
}
