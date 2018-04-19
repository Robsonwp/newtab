/* Rozwiązanie dla rozdział 15., ćwiczenie 2. */

package com.java21days;

import java.io.*;

/* Przed uruchomieniem programu utwórz plik o nazwie junkfile.dat
   w głównym folderze Java21 i umieść w nim tekst lub inne dane. */
public class FileWiper {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new FileInputStream("junkfile.dat");
            boolean eof = false;
            int size = 0;
            while (!eof) {
                int input = file.read();
                if (input == -1) {
                    eof = true;
                } else {
                    size++;
                }
            }
            file.close();
            FileOutputStream outFile = new FileOutputStream("junkfile.dat");
            for (int i = 0; i < size; i++) {
                outFile.write( (byte) 0 );
            }
            outFile.close();
        } catch (IOException e) {
            System.out.println("Błąd -- " + e.toString());
        }
    }
}