package com.java21days;

import java.util.*;

public class CodeKeeper2 {
    ArrayList<String> list;
    String[] codes = { "alfa", "lambda", "gamma", "delta", "zeta" };

    public CodeKeeper2(String[] userCodes) {
        list = new ArrayList<>();
        // wczytaj wbudowane kody
        for (int i = 0; i < codes.length; i++) {
            addCode(codes[i]);
        }
        // wczytaj kody użytkownika
        for (int j = 0; j < userCodes.length; j++) {
            addCode(userCodes[j]);
        }
        // wyświetl wszystkie kody
        for (String code : list) {
            System.out.println(code);
       }
    }

    private void addCode(String code) {
        if (!list.contains(code)) {
            list.add(code);
        }
    }

    public static void main(String[] arguments) {
        CodeKeeper2 keeper = new CodeKeeper2(arguments);
    }
}
