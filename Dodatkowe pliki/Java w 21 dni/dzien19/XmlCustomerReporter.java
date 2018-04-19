/* Rozwiązanie dla rozdział 19., ćwiczenie 2. */

package com.java21days;

import java.io.*;
import java.sql.*;
import nu.xom.*;

public class XmlCustomerReporter {
    public static void main(String[] arguments) {
       String data = "jdbc:derby://localhost:1527/sample";
       try (
           Connection conn = DriverManager.getConnection(
               data, "app", "app");
            Statement st = conn.createStatement()) {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Utwórz element XML do przechowywania wszystkich klientów.
            Element root = new Element("customers");
            
            // Pobierz wszystkich klientów z bazy danych Derby.
            ResultSet rec = st.executeQuery(
                "select CUSTOMER_ID, NAME, CITY, STATE " +
                "from APP.CUSTOMER " +
                "order by CUSTOMER_ID");
            while (rec.next()) {
                // Pobierz element XML dla klienta.
                Element customer = new Element("customer");
                // Utwórz element XML dla identyfikatora klienta.
                Element id = new Element("id");
                // Zapamiętaj w tym elemencie ID rekordu.
                id.appendChild(rec.getString(1));
                // Dodaj ID do elementu klienta.
                customer.appendChild(id);
                // Wykonaj to samo dla nazwy, miasta, i stanu.
                Element name = new Element("name");
                name.appendChild(rec.getString(2));
                customer.appendChild(name);
                Element city = new Element("city");
                city.appendChild(rec.getString(3));
                customer.appendChild(city);
                Element state = new Element("state");
                state.appendChild(rec.getString(4));
                customer.appendChild(state);
                // Dodaj klienta do ekementu XML <customers>.
                root.appendChild(customer);
                System.out.println("Przetwarzanie klienta " + name.getValue());
            }
            st.close();
            // Utwórz dokument XML.
            Document doc = new Document(root);            
            // Utówrz główny element.
            doc.setRootElement(root);
            // Utwórz plik XML i przekaż go do strumienia wyjściowego
            File xml = new File("customer-report.xml");
            FileOutputStream xmlFile = new FileOutputStream(xml);
            Serializer output = new Serializer(xmlFile, "ISO-8859-1");
            output.setIndent(4);
            // Zapisz dokument XML do pliku.
            output.write(doc);
            xmlFile.close();
            System.out.println("\nZapis pliku " + xml.getName());
        } catch (SQLException s) {
            System.out.println("Błąd SQL: " + s.toString() + " "
                + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Błąd: " + e.toString()
                + e.getMessage());
        }
    }
}
