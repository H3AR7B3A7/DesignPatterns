package VisitorPattern;

public class VisitorPattern {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        MyClass myClass = new MyClass(5);
        myClass.acceptVisitor(visitor);
    }
}

interface OriginalInterface {
    void acceptVisitor(Visitor visitor);
}

class MyClass implements OriginalInterface {
    private final int myInt;

    public MyClass(int myInt) {
        this.myInt = myInt;
    }

    public int getMyInt() {
        return myInt;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(MyClass myClass);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(MyClass myClass) {
        System.out.printf("Current value is: %d.\r\n", myClass.getMyInt());
        System.out.println("Visitor printing double of value...");
        System.out.printf("Printed value is: %d.\r\n", myClass.getMyInt() * 2);
        System.out.println("End of visit...");
    }
}