package FacadePattern;

public class FacadePattern {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
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

class ShapeMaker {
    private final Shape rectangle;
    private final Shape square;

    public ShapeMaker() {
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}