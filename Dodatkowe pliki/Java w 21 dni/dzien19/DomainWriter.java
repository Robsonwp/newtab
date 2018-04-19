package com.java21days;

import java.io.*;
import nu.xom.*;

public class DomainWriter {
    public static void main(String[] args) throws IOException {
        try {
            // Utworzenie drzewa z dokumentu XML,
            // który mógłby być podany jako argument wiersza poleceń.
            Builder builder = new Builder();
            File xmlFile = new File("feed2.rss");
            Document doc = builder.build(xmlFile);

            // Utwórz komentarz z aktualną datą i czasem.
            Comment timestamp = new Comment("Plik utworzono o "
                + new java.util.Date());

            // Dodaj komentarz nad wszystkim innym 
            // w dokumencie.
            doc.insertChild(timestamp, 0);

            // Utwórz strumień wyjściowy dla nowego pliku.
            FileOutputStream f = new FileOutputStream("feed3.rss");

            // Wykorzystaj serializację z wcięciami na poziomie 2 spacji
            // w momencie zapisu dokumentu XML.
            Serializer output = new Serializer(f, "ISO-8859-1");
            output.setIndent(2);
            output.write(doc);
        } catch (ParsingException pe) {
            System.out.println("Błąd przetwarzania: " + pe.getMessage());
            pe.printStackTrace();
            System.exit(-1);
        }
    }
}
