package AdapterPattern;

public class AdapterPattern2 {
    public static void main(String[] args) {
        CalculatorAdapter calculatorAdapter = new CalculatorAdapter();
        Triangle triangle = new Triangle(5, 4);
        double result = calculatorAdapter.getArea(triangle);
        System.out.println("The area of the triangle is " + result + " square units");
    }
}

class Rectangle {
    public double width;
    public double height;
}

class Calculator {
    public double getArea(Rectangle rectangle) {
        return rectangle.width * rectangle.height;
    }
}

class Triangle {
    public double width;
    public double height;

    public Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class CalculatorAdapter {
    public double getArea(Triangle triangle) {
        Calculator calculator = new Calculator();
        Rectangle rectangle = new Rectangle();
        rectangle.width = triangle.width;
        rectangle.height = .5 * triangle.height;
        return calculator.getArea(rectangle);
    }
}