package SingletonPattern;

/**
 * Thread Safe Lazy Initialization
 */
public class ThreadSafeLazyInitializationPattern {
    public static void main(String[] args) {
        ThreadSafeLazySingleton singleton = ThreadSafeLazySingleton.getInstance();
        singleton.printMessage();

        ThreadSafeLazySingleton singleton2 = ThreadSafeLazySingleton.getInstance();
        singleton2.printMessage();
    }
}

class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton INSTANCE = null;

    public static synchronized ThreadSafeLazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeLazySingleton();
        }
        return INSTANCE;
    }

    private ThreadSafeLazySingleton() {
    }


    public void printMessage() {
        System.out.println("Inside Singleton function. Singleton Instance: " + this.hashCode());
    }
}