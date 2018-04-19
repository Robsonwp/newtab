/* Rozwiązanie dla rozdział 19., ćwiczenie 2. */

package com.java21days;

import java.io.*;
import nu.xom.*;

public class XmlCustomerReader {
    
    public XmlCustomerReader() {
        try {
            Builder bob = new Builder();
            File xml = new File("customer-report.xml");
            Document doc = bob.build(xml);

            // Pobierz główny element.
            Element root = doc.getRootElement();

            // Pobierz elementy <customer> i przejdź przez nie w pętli.
            Elements customers = root.getChildElements("customer");
            for (int i = 0; i < customers.size(); i++) {
                // Pobierz element <customer>.
                Element customer = customers.get(i);                
                Element id = customer.getFirstChildElement("id");
                Element name = customer.getFirstChildElement("name");
                Element city = customer.getFirstChildElement("city");
                Element state = customer.getFirstChildElement("state");
                System.out.println("ID: " + id.getValue());
                System.out.println("Nazwa: " + name.getValue());
                System.out.println("Miasto: " + city.getValue());
                System.out.println("Stan: " + state.getValue());
                System.out.println();
            }
        } catch (ParsingException | IOException exc) {
            System.out.println("Błąd: " + exc.getMessage());
            exc.printStackTrace();
        }
    }
       
    public static void main(String[] arguments) {
        new XmlCustomerReader();
    }
}
