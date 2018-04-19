/* Rozwiązanie dla rozdział 6., ćwiczenie 1. */

package com.java21days;

public class GiftShop2 {
   public static void main(String[] arguments) {
        Storefront2 store = new Storefront2();
        store.addItem("C01", "KUBEK", "9.99", "150", "NIE");
        store.addItem("C02", "DUŻY KUBEK", "12.99", "82", "TAK");
        store.addItem("C03", "PODKŁADKA", "10.49", "800", "NIE");
        store.addItem("D01", "KOSZULKA", "16.99", "90", "TAK");
        store.sort();
        
        for (int i = 0; i < store.getSize(); i++) {
            Item2 show = (Item2)store.getItem(i);
            System.out.println("\nIdentyfikator elementu: " + show.getId() +
                "\nNazwa: " + show.getName() +
                "\nCena sprzedaży: " + show.getRetail() + " zł" +
                "\nCena: " + show.getPrice() + " zł" +
                "\nSztuk: " + show.getQuantity());
        }
    }
}
 
