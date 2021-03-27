package AdapterPattern;

import java.util.ArrayList;
import java.util.List;

public class AdapterPattern3 {
    public static void main(String[] args) {
        Rect rectangle = new Rect(5, 10);
        System.out.printf("Rectangle area = %.2f square units.\r\n", rectangle.calculateAreaOfRectangle());

        Tri triangle = new Tri(5, 10);
        System.out.printf("Triangle area = %.2f square units.\r\n", triangle.calculateAreaOfTriangle());

        System.out.printf("Rectangle area using RectInterface = %.2f square units.\r\n", getArea(rectangle));

        RectInterface adapter = new TriangleAdapter(triangle);
        System.out.printf("Triangle area using triangle adapter in RectInterface = %.2f square units.\r\n", getArea(adapter));

        List<RectInterface> shapes = new ArrayList<>();
        shapes.add(rectangle);
        shapes.add(adapter);
        for (RectInterface shape : shapes) {
            shape.aboutRectangle();
        }
    }

    static double getArea(RectInterface rectInterface) {
        return rectInterface.calculateAreaOfRectangle();
    }
}

interface RectInterface {
    void aboutRectangle();

    double calculateAreaOfRectangle();
}

class Rect implements RectInterface {
    public double width;
    public double height;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void aboutRectangle() {
        System.out.printf("Rectangle with width: %.2f, and height: %.2f.\r\n", width, height);
    }

    @Override
    public double calculateAreaOfRectangle() {
        return width * height;
    }
}

interface TriInterface {
    void aboutTriangle();

    double calculateAreaOfTriangle();
}

class Tri implements TriInterface {
    public double width;
    public double height;

    public Tri(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void aboutTriangle() {
        System.out.printf("Triangle with width: %.2f, and height: %.2f.\r\n", width, height);
    }

    @Override
    public double calculateAreaOfTriangle() {
        return .5 * width * height;
    }
}

class TriangleAdapter implements RectInterface {
    Tri triangle;

    public TriangleAdapter(Tri triangle) {
        this.triangle = triangle;
    }

    @Override
    public void aboutRectangle() {
        triangle.aboutTriangle();
    }

    @Override
    public double calculateAreaOfRectangle() {
        return triangle.calculateAreaOfTriangle();
    }
}