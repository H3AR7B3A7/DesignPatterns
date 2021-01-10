package PrototypePattern;

import java.util.Hashtable;

public class PrototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {

        ShapeCache.loadCache();
        Shape clone = ShapeCache.getShape("2");
        clone.draw();
        System.out.println(clone.getId());
        System.out.println(clone.getType());
    }
}

class ShapeCache {
    private static final Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId("1");
        shapeMap.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);
    }
}

abstract class Shape implements Cloneable {
    private String id;
    String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("I'm almost square.");
    }
}

class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("I'm square.");
    }
}
