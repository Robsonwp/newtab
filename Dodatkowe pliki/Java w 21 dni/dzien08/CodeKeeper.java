package com.java21days;

import java.util.*;

public class CodeKeeper {
    ArrayList list;
    String[] codes = { "alfa", "lambda", "gamma", "delta", "zeta" };

    public CodeKeeper(String[] userCodes) {
        list = new ArrayList();
        // wczytaj kody wbudowane 
        for (int i = 0; i < codes.length; i++) {
            addCode(codes[i]);
        }
        // wczytaj kody użytkownika
        for (int j = 0; j < userCodes.length; j++) {
            addCode(userCodes[j]);
        }
        // wyświetl wszystkie kody
        for (Iterator ite = list.iterator(); ite.hasNext(); ) {
            String output = (String) ite.next();
            System.out.println(output);
       }
    }

    private void addCode(String code) {
        if (!list.contains(code)) {
            list.add(code);
        }
    }

    public static void main(String[] arguments) {
        CodeKeeper keeper = new CodeKeeper(arguments);
    }
}
