/* Rozwiązanie dla rozdział 18., ćwiczenie 2. */

package com.java21days;

import java.sql.*;

public class QuoteReader {
    String ticker;
    
    public QuoteReader(String ticker) {
        this.ticker = ticker;
    }
    
    public void readStocks() {
       String data = "jdbc:derby://localhost:1527/sample";
       try (
           Connection conn = DriverManager.getConnection(
               data, "app", "app");
           Statement st = conn.createStatement()) {

           Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet rec = st.executeQuery(
                "select TICKER, PRICE, DATE, CHANGE, LOW, HIGH, PRICEOPEN, VOLUME " +
                "from STOCKS WHERE TICKER = '" + ticker + "' " +
                "order by DATE");
            boolean hasResults = false;
            while (rec.next()) {
                System.out.println("DATE:\t"
                    + rec.getString(3));
                System.out.println("TICKER:\t" + rec.getString(1));
                System.out.println("PRICE:\t" + rec.getString(2));
                System.out.println("CHANGE:\t" + rec.getString(4));
                System.out.println("LOW:\t" + rec.getString(5));
                System.out.println("HIGH:\t" + rec.getString(6));
                System.out.println("PRICEOPEN:\t" + rec.getString(7));
                System.out.println("VOLUME:\t" + rec.getString(8));
                System.out.println();
                hasResults = true;
            }
            if (!hasResults) {
                System.out.println("Nie znaleziono wpisów dla " + ticker);
            }
            st.close();
        } catch (SQLException s) {
            System.out.println("Błąd SQL: " + s.toString() + " "
                + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Błąd: " + e.toString()
                + e.getMessage());
        }
    }
    
    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Użycie: java QuoteReader kod");
            System.exit(-1);
        }
        new QuoteReader(arguments[0]).readStocks();
    }
}