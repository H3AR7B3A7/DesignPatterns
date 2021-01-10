package SingletonPattern;

/**
 * Eager Initialization
 */
public class EagerInitializationPattern {

    public static void main(String[] args) {
        EagerInitializationSingleton singleton = EagerInitializationSingleton.getInstance();
        singleton.printMessage();

        EagerInitializationSingleton singleton2 = EagerInitializationSingleton.getInstance();
        singleton2.printMessage();
    }
}

class EagerInitializationSingleton {

    private static final EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();

    private EagerInitializationSingleton() {
    }

    public static EagerInitializationSingleton getInstance() {
        return INSTANCE;
    }

    public void printMessage() {
        System.out.println("Inside Singleton function. Singleton Instance: " + this.hashCode());
    }
}