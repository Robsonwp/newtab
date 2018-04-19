/* Rozwiązanie dla rozdział 20., ćwiczenie 2. */

package com.java21days;

import java.io.IOException;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class PingServer {
    public static void main(String[] arguments) {
         try {
             startServer(7667);
        } catch (IOException | XmlRpcException ex) {
            System.out.println("Błąd serwera: " +
                ex.getMessage());
        }
    }

    public static void startServer(int port) throws IOException, XmlRpcException {
        // start the server
        System.out.println("Uruchamianie serwera ping...");
        WebServer server = new WebServer(port);
        XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        
        // register the handler
        phm.addHandler("weblogUpdates", PingHandlerImpl.class);
        xmlRpcServer.setHandlerMapping(phm);
        
        server.start();
        System.out.println("Akceptacja żądań...");
    }
}
