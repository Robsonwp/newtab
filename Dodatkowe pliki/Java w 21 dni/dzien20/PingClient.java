/* Rozwiązanie dla rozdział 20., ćwiczenie 2. */

package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class PingClient {
    XmlRpcClient client;
    
    public PingClient() {
        this("http://localhost:7667/");
    }
    
    public PingClient(String serverUrl) {
        try {
            // utwórz klienta
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            URL server = new URL(serverUrl);
            config.setServerURL(server);
            client = new XmlRpcClient();
            client.setConfig(config);
        } catch (MalformedURLException exception) {
            System.out.println("Zły URL: " + serverUrl);
        }
    }
    
    public HashMap ping(String siteName, String siteUrl) 
        throws IOException, XmlRpcException {
            
        ArrayList<String> params = new ArrayList<>();
        params.add(siteName);
        params.add(siteUrl);
        Object result = client.execute("weblogUpdates.ping", params);
        if (result instanceof XmlRpcException) {
        	throw (XmlRpcException) result;
        }
        return (HashMap) result;
    }
       
    public static void main(String[] arguments) {
        if (arguments.length < 2) {
            System.out.println("Użycie: java PingClient nazwa url");
            System.exit(-1);
        }
        try {
            PingClient pinger;
            pinger = new PingClient();
            HashMap response = pinger.ping(arguments[0], arguments[1]);
            System.out.println(response.get("message"));
        } catch (IOException | XmlRpcException exception) {
            System.out.println("Błąd: " + exception.getMessage());
            exception.printStackTrace();
        }
    }
}
