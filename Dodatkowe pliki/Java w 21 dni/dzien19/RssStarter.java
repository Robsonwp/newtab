package com.java21days;

import java.io.*;
import nu.xom.*;

public class RssStarter {
    public static void main(String[] arguments) {
        // Utwórz element <rss> jako korzeń całego dokumentu.
        Element rss = new Element("rss");

        // Dodaj atrybut version do elementu.
        Attribute version = new Attribute("version", "2.0");
        rss.addAttribute(version);
        // Utwórz element <channel> i uczyń go podelementem elementu <rss>.
        Element channel = new Element("channel");
        rss.appendChild(channel);
        // Utwórz tytuł jako element <title>.
        Element title = new Element("title");
        Text titleText = new Text("Workbench");
        title.appendChild(titleText);
        channel.appendChild(title);
        // Utwórz element <link> kanału.
        Element link = new Element("link");
        Text lText = new Text("http://workbench.cadenhead.org/");
        link.appendChild(lText);
        channel.appendChild(link);

        // Utwórz nowy dokument z <rss> jako element główny.
        Document doc = new Document(rss);

        // Zapisz dokument XML.
        try (
            FileWriter fw = new FileWriter("feed.rss");
            BufferedWriter out = new BufferedWriter(fw);
        ) {
            out.write(doc.toXML());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        System.out.println(doc.toXML());
    }
}
