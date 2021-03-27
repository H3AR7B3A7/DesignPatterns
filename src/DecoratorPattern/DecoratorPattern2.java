package DecoratorPattern;

public class DecoratorPattern2 {
    public static void main(String[] args) {
        ConcreteComponent withoutDecorator = new ConcreteComponent();
        withoutDecorator.makeHouse();

        System.out.println("____");

        FloorDecorator floorDecorator = new FloorDecorator();
        floorDecorator.setComponent(withoutDecorator);
        floorDecorator.makeHouse();

        System.out.println("____");

        PaintDecorator paintDecorator = new PaintDecorator();
        paintDecorator.setComponent(floorDecorator);
        paintDecorator.makeHouse();
    }
}

abstract class Component {
    public abstract void makeHouse();
}

class ConcreteComponent extends Component {
    @Override
    public void makeHouse() {
        System.out.println("Original house is complete. It is closed for modification");
    }
}

abstract class AbstractDecorator extends Component {
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void makeHouse() {
        if (component != null) {
            component.makeHouse();
        }
    }
}

class FloorDecorator extends AbstractDecorator {
    @Override
    public void makeHouse() {
        super.makeHouse();
        System.out.println("*** Floor decorator in action. ***");
        addFloor();
    }

    private void addFloor() {
        System.out.println("Creating an additional floor...");
    }
}

class PaintDecorator extends AbstractDecorator {
    @Override
    public void makeHouse() {
        super.makeHouse();
        System.out.println("*** Paint decorator in action. ***");
        paintHouse();
    }

    private void paintHouse() {
        System.out.println("Painting the house...");
    }
}