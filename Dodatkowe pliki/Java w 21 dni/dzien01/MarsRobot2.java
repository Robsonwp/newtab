/* Rozwiązanie dla rozdział 1., ćwiczenie 1. */
class MarsRobot2 {
    String status;
    int speed;
    float temperature;

    void checkTemperature() {
        if (temperature < -62) {
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
        MarsRobot2 spirit = new MarsRobot2();
        spirit.status = "eksploracja";
        spirit.speed = 2;
        spirit.temperature = -60;

        System.out.println("\nDuch:");
        spirit.showAttributes();
        System.out.println("Zwiększanie prędkości do 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("Zmiana temperatury na 670.");
        spirit.temperature = 670;
        spirit.showAttributes();
        System.out.println("Sprawdzenie temperatury.");
        spirit.checkTemperature();
        spirit.showAttributes();

        MarsRobot2 opportunity = new MarsRobot2();
        System.out.println("\nDuch:");
        opportunity.status = "eksploracja";
        opportunity.speed = 4;
        opportunity.temperature = -90;
        opportunity.showAttributes();
    }
}
