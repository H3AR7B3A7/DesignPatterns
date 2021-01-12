package PrototypePattern;

import java.util.Random;

public class PrototypePattern2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseCar nano = new Nano("Green Nano");
        nano.basePrice = 10000;

        BaseCar ford = new Ford("Blue Ford");
        ford.basePrice = 50000;

        BaseCar bc1;
        bc1 = nano.clone();
        bc1.onRoadPrice = nano.basePrice + BaseCar.setAdditionalPrice();
        System.out.println(bc1.modelName + " for €" + bc1.onRoadPrice);

        BaseCar bc2;
        bc2 = ford.clone();
        bc2.onRoadPrice = ford.basePrice + BaseCar.setAdditionalPrice();
        System.out.println(bc2.modelName + " for €" + bc2.onRoadPrice);
    }
}

abstract class BaseCar implements Cloneable {
    public String modelName;
    public int basePrice, onRoadPrice;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static int setAdditionalPrice() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    @Override
    protected BaseCar clone() throws CloneNotSupportedException {
        return (BaseCar) super.clone();
    }
}

class Nano extends BaseCar {

    public Nano(String modelName) {
        this.modelName = modelName;
    }

    @Override
    protected BaseCar clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Ford extends BaseCar {

    public Ford(String modelName) {
        this.modelName = modelName;
    }

    @Override
    protected BaseCar clone() throws CloneNotSupportedException {
        return super.clone();
    }
}