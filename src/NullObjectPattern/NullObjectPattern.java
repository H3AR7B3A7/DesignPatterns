package NullObjectPattern;

import java.util.Scanner;

public class NullObjectPattern {
    public static void main(String[] args) {
        String input = "dummyInput";
        int totalObjects = 0;
        Scanner scanner;
        while (!input.toLowerCase().contains("exit")) {
            System.out.println("Enter 'a' for bus, 'b' for train... 'exit' to close application.");
            scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            }
            Vehicle vehicle = null;
            switch (input.toLowerCase()) {
                case "a":
                    vehicle = new Bus();
                    break;
                case "b":
                    vehicle = new Train();
                    break;
                case "exit":
                    System.out.println("Closing the application.");
                    vehicle = NullVehicle.getInstance();
                    break;
                default:
                    System.out.println("Invalid input");
                    vehicle = NullVehicle.getInstance();
            }
            totalObjects = Bus.busCount + Train.trainCount + NullVehicle.nullVehicleCount;
            vehicle.travel();
            System.out.println("Total number of objects created is: " + totalObjects);
        }
    }
}

interface Vehicle {
    void travel();
}

class Bus implements Vehicle {
    public static int busCount = 0;

    public Bus() {
        busCount++;
    }

    @Override
    public void travel() {
        System.out.println("Traveling by bus...");
    }
}

class Train implements Vehicle {
    public static int trainCount = 0;

    public Train() {
        trainCount++;
    }

    @Override
    public void travel() {
        System.out.println("Traveling by train...");
    }
}

class NullVehicle implements Vehicle {
    private static final NullVehicle instance = new NullVehicle();
    public static int nullVehicleCount;

    private NullVehicle() {
        nullVehicleCount++;
        System.out.println("A null vehicle object created. Currently there are: " + nullVehicleCount);
    }

    public static NullVehicle getInstance() {
        return instance;
    }

    @Override
    public void travel() {
        // Do nothing
    }
}