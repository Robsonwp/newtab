package com.java21days;

class Printer {

    int x = 0;
    int y = 1;

    void printMe() {
        System.out.println("x wynosi " + x + ", y wynosi " + y);
        System.out.println("Jestem egzemplarzem klasy "
                + this.getClass().getName());
    }
}

class SubPrinter extends Printer {

    int z = 3;

    public static void main(String[] arguments) {
        SubPrinter obj = new SubPrinter();
        obj.printMe();
    }
}
