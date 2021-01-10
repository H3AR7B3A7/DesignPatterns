package FactoryPattern;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFormFactory formFactory = FactoryProducer.getFactory(true);
        Form form1 = formFactory.getForm("square");
        form1.draw();

        formFactory = FactoryProducer.getFactory(false);
        Form form2 = formFactory.getForm("rectangle");
        form2.draw();
    }
}

interface Form {
    void draw();
}

class Rect implements Form {

    @Override
    public void draw() {
        System.out.println("I'm almost square.");
    }
}

class RoundedRect implements Form {

    @Override
    public void draw() {
        System.out.println("I'm almost square and rounded.");
    }
}

class RhomboidRectangle implements Form {

    @Override
    public void draw() {
        System.out.println("I'm square.");
    }
}

class RoundedRhomboidRectangle implements Form {

    @Override
    public void draw() {
        System.out.println("I'm square and rounded.");
    }
}

abstract class AbstractFormFactory {
    abstract Form getForm(String shapeType);
}

class FormFactory extends AbstractFormFactory {

    @Override
    public Form getForm(String formType) {
        if (formType.equalsIgnoreCase("RECTANGLE")) {
            return new Rect();
        } else if (formType.equalsIgnoreCase("SQUARE")) {
            return new RhomboidRectangle();
        }
        return null;
    }
}

class RoundedFormFactory extends AbstractFormFactory {

    @Override
    Form getForm(String formType) {
        if (formType.equalsIgnoreCase("RECTANGLE")) {
            return new RoundedRect();
        } else if (formType.equalsIgnoreCase("SQUARE")) {
            return new RoundedRhomboidRectangle();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFormFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedFormFactory();
        } else {
            return new FormFactory();
        }
    }
}