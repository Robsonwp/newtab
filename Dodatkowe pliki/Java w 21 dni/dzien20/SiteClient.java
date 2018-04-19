package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class SiteClient {
    public static void main(String arguments[]) {
        SiteClient client = new SiteClient();
        try {
            HashMap<String, String> resp = client.getRandomSite();
            // zgłoś wyniki
            if (resp.size() > 0) {
                System.out.println("URL: " + resp.get("url")
                    + "\nTytuł: " + resp.get("title")
                    + "\nOpis: " + resp.get("description"));
            }
        } catch (IOException ioe) {
            System.out.println("Wyjątek: " + ioe.getMessage());
        } catch (XmlRpcException xre) {
            System.out.println("Wyjątek: " + xre.getMessage());
        }
    }

    public HashMap getRandomSite()
        throws IOException, XmlRpcException {

            // utwórz klienta
            XmlRpcClientConfigImpl config = new
                XmlRpcClientConfigImpl();
            URL server = new URL("http://localhost:4413/");
            config.setServerURL(server);
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            // utworzenie parametrów dla żądania
            ArrayList params = new ArrayList();
            // wyślij żądanie i odbierz odpowiedź
            HashMap result = (HashMap) client.execute(
                "dmoz.getRandomSite", params);
            return result;
    }
}
