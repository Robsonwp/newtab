/* Rozwiązanie dla rozdział 5., ćwiczenie 1. */

package com.java21days;

public class MarsRobot3 {
    String status;
    int speed;
    float temperature;

    MarsRobot3(String inStatus, int inSpeed, float inTemperature) {
        status = inStatus;
        speed = inSpeed;
        temperature = inTemperature;
    }    
    
    void checkTemperature() {
        if (temperature < -80) {
            status = "powrót do domu";
            speed = 5;
        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Prędkość: " + speed);
        System.out.println("Temperatura: " + temperature);
    }
    
    public static void main(String[] arguments) {
        MarsRobot3 spirit = new MarsRobot3("eksploracja", 2, -80);

        spirit.showAttributes();
        System.out.println("Zwiększanie prędkości do 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("Zmiana temperatury na -100.");
        spirit.temperature = -100;
        spirit.showAttributes();
        System.out.println("Sprawdzenie temperatury.");
        spirit.checkTemperature();
        spirit.showAttributes();
    }
}
