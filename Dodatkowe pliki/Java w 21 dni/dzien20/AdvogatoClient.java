/* Rozwiązanie dla rozdział 20., ćwiczenie 1. */

package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class AdvogatoClient {
    XmlRpcClient client;
    
    public AdvogatoClient() {
        this("http://www.advogato.org:80/XMLRPC");
    }
    
    public AdvogatoClient(String serverUrl) {
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
    
    public Integer getEntryCount(String username) 
        throws IOException, XmlRpcException {
            
        ArrayList<Object> params = new ArrayList<>();
        params.add(username);
        Integer result = (Integer) client.execute("dziennik.len", params);
        return result;
    }
    
    public String getEntry(String username, Integer index) 
        throws IOException, XmlRpcException {
        	
    	ArrayList<Object> params = new ArrayList<>();
        params.add(username);
        params.add(index);
        String result = (String) client.execute("dziennik.get", params);
        return result;
    }
    
    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java AdvogatoClient username");
            System.exit(-1);
        }
        try {
            AdvogatoClient advo;
            advo = new AdvogatoClient();
            int entryCount = advo.getEntryCount(arguments[0]);
            if (entryCount > 10) {
                entryCount = 10;
            }
            for (int i = 0; i < entryCount; i++) {
            	String entry = advo.getEntry(arguments[0], i);
            	System.out.println(entry);
            }
            System.out.println("");
        } catch (IOException | XmlRpcException exception) {
            System.out.println("Błąd: " + exception.getMessage());
            exception.printStackTrace();
        }
    }
}