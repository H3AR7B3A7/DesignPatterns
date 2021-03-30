package StrategyPattern;

public class StrategyPattern2 {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Boat();
        vehicle1.showMe();
        vehicle1.showTransportMedium();
        System.out.println("____");
        Vehicle vehicle2 = new Aeroplane();
        vehicle2.showMe();
        vehicle2.showTransportMedium();
    }
}

abstract class Vehicle {
    TransportMedium transportMedium;

    public void showTransportMedium() {
        transportMedium.transport();
    }

    public void commonJob() {
        System.out.println("We all can be used to transport.");
    }

    public abstract void showMe();
}

class Boat extends Vehicle {
    public Boat() {
        transportMedium = new WaterTransport();
    }

    @Override
    public void showMe() {
        System.out.println("I am a boat.");
    }
}

class Aeroplane extends Vehicle {
    public Aeroplane() {
        transportMedium = new AirTransport();
    }

    @Override
    public void showMe() {
        System.out.println("I am a plane.");
    }
}

interface TransportMedium {
    void transport();
}

class WaterTransport implements TransportMedium {
    @Override
    public void transport() {
        System.out.println("I am transporting through the water.");
    }
}

class AirTransport implements TransportMedium {
    @Override
    public void transport() {
        System.out.println("I am transporting through the air");
    }
}