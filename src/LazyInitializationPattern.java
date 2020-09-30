/**
 * Lazy Initialization
 */
public class LazyInitializationPattern {
    public static void main(String[] args){
        LazySingleton singleton = LazySingleton.getInstance();
        singleton.printMessage();

        LazySingleton singleton2 = LazySingleton.getInstance();
        singleton2.printMessage();
    }
}

class LazySingleton {

    private static LazySingleton INSTANCE = null;

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton ();
        }
        return INSTANCE;
    }

    private LazySingleton() {}


    public void printMessage(){
        System.out.println("Inside Singleton function. Singleton Instance: "+this.hashCode());
    }
}