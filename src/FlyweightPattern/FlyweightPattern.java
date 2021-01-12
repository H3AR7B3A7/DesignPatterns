package FlyweightPattern;

import java.util.HashMap;
import java.util.Random;

public class FlyweightPattern {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(random.nextInt(colors.length))];
    }

    private static int getRandomX() {
        return (random.nextInt(101));
    }

    private static int getRandomY() {
        return (random.nextInt(101));
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    private final String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius + "]");
    }
}

class ShapeFactory {

    @SuppressWarnings("unchecked")
    private static final HashMap circleMap = new HashMap();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}