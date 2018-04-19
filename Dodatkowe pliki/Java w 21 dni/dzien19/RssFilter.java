package com.java21days;

import nu.xom.*;

public class RssFilter {
    public static void main(String[] arguments) {

        if (arguments.length < 2) {
            System.out.println("Użycie: java RssFilter plik tekst");
            System.exit(-1);
        }

        // Zapisz lokalizację RSS i wyszukiwany tekst.
        String rssFile = arguments[0];
        String term = arguments[1];

        try {
            // Wypełnij drzewo danymi XML z pliku RSS.
            // Plik może znajdować się na dysku lub być
            // pobierany z sieci internet na podstawie adresu URL.
            Builder bob = new Builder();
            Document doc = bob.build(rssFile);

            // Pobierz główny element (<rss>).
            Element rss = doc.getRootElement();

            // Pobierz atrybut wersji.
            Attribute rssVersion = rss.getAttribute("version");
            String version = rssVersion.getValue();

            // Dodaj DTD dla plików RSS 0.91, jeśli to niezbędne.
            if ( (version.equals("0.91")) &
                (doc.getDocType() == null) ) {

                DocType rssDtd = new DocType("rss",
                    "http://my.netscape.com/publish/formats/rss-0.91.dtd");
                doc.insertChild(rssDtd, 0);
            }

            // Pobierz pierwszy (i jedyny) element <channel>.
            Element channel = rss.getFirstChildElement("channel");

            // Pobierz element <title>.
            Element title = channel.getFirstChildElement("title");
            Text titleText = (Text) title.getChild(0);

            // Zmień tytuł, aby dotyczył poszukiwanego tekstu.
            titleText.setValue(titleText.getValue() + 
                ": Poszukiwanie artykułów o tematyce " + term);

            // Pobierz wszystkie elementy <item> i przejdź przez nie w pętli.
            Elements items = channel.getChildElements("item");
            for (int i = 0; i < items.size(); i++) {
                // Pobierz element <item>.
                Element item = items.get(i);

                // Znajdź element <title> wewnątrz.
                Element iTitle = item.getFirstChildElement("title");

                // Jeśli istnieje, sprawdź jego zawartość.
                if (iTitle != null) {
                    Text iTitleText = (Text) iTitle.getChild(0);

                    // Jeśli poszukiwanego tekstu nie naleziono,
                    // usuń wpis z drzewa.
                    if (iTitleText.toString().indexOf(term) == -1) {
                        channel.removeChild(item);
                    }
                }
            }

            // Wyświetl wynik jako efekt serializacji.
            Serializer output = new Serializer(System.out);
            output.setIndent(2);
            output.write(doc);
        } catch (Exception exc) {
            System.out.println("Błąd: " + exc.getMessage());
            exc.printStackTrace();
        }
    }
}
