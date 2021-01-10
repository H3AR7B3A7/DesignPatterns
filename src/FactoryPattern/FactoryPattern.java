package FactoryPattern;

public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("square");
        shape1.draw();
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm almost square.");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm square.");
    }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (type.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}