/* Rozwiązanie dla rozdział 19., ćwiczenie 1. */

package com.java21days;

import java.io.*;
import nu.xom.*;

public class BookFilter {
    
    public BookFilter() {
    	// nie ma potrzeby inicjalizacji
    }
    
    public void read() {    	
        try {
            Builder bob = new Builder();
            File xmlFile = new File("books.xml");
            Document doc = bob.build(xmlFile);

            // Pobierz główne elementy pliku.
            Element root = doc.getRootElement();

            // Pobierz elementy <book> i przejdź przez nie w pętli.
            Elements books = root.getChildElements("Book");
            for (int i = 0; i < books.size(); i++) {
                // Pobierz element <book>.
                Element book = books.get(i);
                
                // Poszukaj w nim elementu <author>.
                Element author = book.getFirstChildElement("Author");
                
                // Jeśli znaleziony, znajdź zawartość.
                if (author != null) {
                    Text authorText = (Text) author.getChild(0);
                    String authorName = authorText.getValue();
                    
                    if (authorName.equals("George R.R. Martin")) {
                        System.out.println("\Autor: " + authorName);
                        // Display the other elements
                        Element title = book.getFirstChildElement("Title");
                        display("Tytuł", title);
                        Element pubDate = book.getFirstChildElement("PubDate");
                        display("Data publikacji", pubDate);
                        Attribute edition = pubDate.getAttribute("edition");
                        displayAttribute("Wydanie", edition);
                        Attribute isbn = pubDate.getAttribute("isbn");
                        displayAttribute("ISBN", isbn);
                        Element publisher = book.getFirstChildElement("Publisher");
                        display("Wydawca", publisher);
                        Element subject = book.getFirstChildElement("Subject");
                        display("Tematyka", subject);
                        Element review = book.getFirstChildElement("Review");
                        display("Ocena", review);
                    }
                }
            }
        } catch (ParsingException | IOException exc) {
            System.out.println("Błąd: " + exc.getMessage());
            exc.printStackTrace();
        }
    }
    
    // Wyświetl tekst ze środka elementu (jeśli istnieje).
    void display(String label, Element element) {
    	if (element != null) {
            Text elementText = (Text) element.getChild(0);
            String elementString = elementText.getValue();
            System.out.println(label + ": " + elementString);
    	}
    }    		
    
    // Wyświetl wartość atrybutu (jeśli istnieje).
    void displayAttribute(String label, Attribute attribute) {
    	if (attribute != null) {
            String attributeString = attribute.getValue();
            System.out.println(label + ": " + attributeString);
    	}
    }
    
    public static void main(String[] arguments) {
        BookFilter bf = new BookFilter();
        bf.read();
    }
}
