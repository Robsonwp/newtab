package com.java21days;

import java.io.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.*;

public class DmozServer {
    public static void main(String[] arguments) {
         try {
             startServer();
         } catch (IOException ioe) {
             System.out.println("Błąd serwera: " +
                 ioe.getMessage());
         } catch (XmlRpcException xre) {
             System.out.println("Błąd XML-RPC: " +
                 xre.getMessage());
         }
    }

    public static void startServer() throws IOException,
        XmlRpcException {

        // utworzenie serwera
        System.out.println("Uruchamianie serwera Dmoz...");
        WebServer server = new WebServer(4413);
        XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();

        // rejestracja obsługi
        phm.addHandler("dmoz", DmozHandlerImpl.class);
        xmlRpcServer.setHandlerMapping(phm);

        // uruchomienie serwera
        server.start();
        System.out.println("Akceptacja żądań...");
    }
}
