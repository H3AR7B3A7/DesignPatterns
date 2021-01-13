package FactoryPattern;

public class AbstractFactoryPattern2 {
    public static void main(String[] args) {
        BeastFactory myBeastFactory;

        Bird myBird;
        Rabbit myRabbit;

        myBeastFactory = new WildAnimalFactory();
        myBird = myBeastFactory.createBird();
        myBird.speak();
        myBird.action();

        myBeastFactory = new PetAnimalFactory();
        myRabbit = myBeastFactory.createRabbit();
        myRabbit.speak();
        myRabbit.action();
    }
}

interface Bird {

    void speak();
    void action();
}

interface Rabbit {

    void speak();
    void action();
}

class WildBird implements Bird {
    @Override
    public void speak() {
        System.out.println("Kraaa!!");
    }

    @Override
    public void action() {
        System.out.println("The bird flies away.");
    }
}

class WildRabbit implements Rabbit {
    @Override
    public void speak() {
        System.out.println("Yeet!!");
    }

    @Override
    public void action() {
        System.out.println("The rabbit runs away.");
    }
}

class PetBird implements Bird {
    @Override
    public void speak() {
        System.out.println("Tjirp.");
    }

    @Override
    public void action() {
        System.out.println("The bird sits on your shoulder.");
    }
}

class PetRabbit implements Rabbit {
    @Override
    public void speak() {
        System.out.println("Sniffels..");
    }

    @Override
    public void action() {
        System.out.println("The rabbit sits on your lap.");
    }
}

interface BeastFactory {

    Bird createBird();
    Rabbit createRabbit();
}

class WildAnimalFactory implements BeastFactory {
    @Override
    public Bird createBird() {
        return new WildBird();
    }

    @Override
    public Rabbit createRabbit() {
        return new WildRabbit();
    }
}

class PetAnimalFactory implements BeastFactory {
    @Override
    public Bird createBird() {
        return new PetBird();
    }

    @Override
    public Rabbit createRabbit() {
        return new PetRabbit();
    }
}