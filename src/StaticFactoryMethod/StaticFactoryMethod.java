package StaticFactoryMethod;

public class StaticFactoryMethod {
    public static void main(String[] args) {
        Animal cat = Animal.createCat("Tails");
        Animal cat2 = Animal.createCat("Purr");

        Animal dog = Animal.createDog("Fifi");
        Animal dog2 = Animal.createDog("Fifi");
        Animal dog3 = Animal.createDog("Wolf");

        System.out.println(dog3);
        System.out.println(dog2);

        System.out.println(cat.equals(cat2));
        System.out.println(dog.equals(dog2));
        System.out.println(dog.equals(dog3));
    }
}

class Animal {
    private static Dog dog;

    public static Animal createCat(String name) {
        return new Cat(name);
    }

    public static Animal createDog(String name) {
        if (dog == null) {
            dog = new Dog(name);
        } else if (!dog.name.equals(name)) {
            dog.name = name;
        }
        return dog;
    }
}

class Cat extends Animal {
    String name;

    Cat(String name) {
        this.name = name;
        System.out.printf("A cat was conceived, named %s.\n", name);
    }
}

class Dog extends Animal {
    String name;

    Dog(String name) {
        this.name = name;
        System.out.printf("A dog was conceived, named %s.\n", name);
    }

    @Override
    public String toString() {
        return name;
    }
}
