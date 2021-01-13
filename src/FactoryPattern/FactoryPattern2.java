package FactoryPattern;

public class FactoryPattern2 {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();

        Animal dog = dogFactory.createAnimal();
        Animal cat = catFactory.createAnimal();

        dog.speak();
        dog.action();

        cat.speak();
        cat.action();

        Animal dog2 = dogFactory.makeAnimal();
        Animal cat2 = catFactory.makeAnimal();
    }
}

interface Animal {

    void speak();
    void action();
}

class Dog implements Animal {

    @Override
    public void speak() {
        System.out.println("Woef!");
    }

    @Override
    public void action() {
        System.out.println("The dog wags his tail.");
    }
}

class Cat implements Animal {

    @Override
    public void speak() {
        System.out.println("Miauw!");
    }

    @Override
    public void action() {
        System.out.println("The cat purrs.");
    }
}

abstract class AnimalFactory {
    public abstract Animal createAnimal();

    public Animal makeAnimal() {
        System.out.println("Some magic needs to happen to make new animals...");
        Animal animal = createAnimal();
        animal.speak();
        animal.action();
        return animal;
    }

    ;
}

class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}