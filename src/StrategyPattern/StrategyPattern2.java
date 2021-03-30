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
        System.out.println("____");
        vehicle2.commonJob();
        System.out.println("____");
        Vehicle vehicle3 = new SpecialVehicle();
        vehicle3.showMe();
        vehicle3.showTransportMedium();
        vehicle3.setTransportMedium(new AirTransport());
        vehicle3.showTransportMedium();
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

    public void setTransportMedium(TransportMedium transportMedium) {
        this.transportMedium = transportMedium;
    }
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

class SpecialVehicle extends Vehicle {
    public SpecialVehicle() {
        transportMedium = new WaterTransport();
    }

    @Override
    public void showMe() {
        System.out.println("I am a special vehicle that can transport in both water and air.");
    }
}