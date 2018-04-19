package com.java21days;

import java.io.*;
import nu.xom.*;

public class DomainEditor {
    public static void main(String[] args) throws IOException {
        try {
            // Utwórz drzewo dla pliku feed.rss
            Builder builder = new Builder();
            File xmlFile = new File("feed.rss");
            Document doc = builder.build(xmlFile);

            // Pobierz główny element <rss>.
            Element root = doc.getRootElement();

            // Pobierz element <channel>.
            Element channel = root.getFirstChildElement("channel");

            // Pobierz elementy <link>.
            Elements children = channel.getChildElements();
            for (int i = 0; i < children.size(); i++) {

                // Pobierz element <link>.
                Element link = children.get(i);

                // Pobierz tekst.
                Text linkText = (Text) link.getChild(0);

                // Pobierz łącze dotyczące konkretnego adresu URL.
                if (linkText.getValue().equals(
                    "http://workbench.cadenhead.org/")) {

                    // Uaktualnij treść łącza.
                    link.removeChild(0);
                    link.appendChild("http://www.cadenhead.org/");
                }
            }

            // Utwóz nowe elemebty i ich atrybuty.
            Element item = new Element("item");
            Element itemTitle = new Element("title");

            // Dodaj je do elementu <channel>.
            itemTitle.appendChild(
                "Uwolnić wszystkie periodyki"
            );
            item.appendChild(itemTitle);
            channel.appendChild(item);

            // Zapisz dokument XML.
            try (
                FileWriter fw = new FileWriter("feed2.rss");
                BufferedWriter out = new BufferedWriter(fw);
            ) {
                out.write(doc.toXML());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            System.out.println(doc.toXML());
        } catch (ParsingException pe) {
            System.out.println("Błąd przetwarzania: " + pe.getMessage());
            pe.printStackTrace();
            System.exit(-1);
        }
    }
}
