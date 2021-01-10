package SingletonPattern;

/**
 * ENUM Singleton
 */
public class EnumPattern {
    public static void main(String[] args){
        EnumSingleton singleton = EnumSingleton.Instance;
        singleton.printMessage();

        EnumSingleton singleton2 = EnumSingleton.Instance;
        singleton2.printMessage();
    }
}

enum EnumSingleton {
    Instance;

    // Constructor called by JVM implicitly, but can also be declared.
//    private SingletonPattern.EnumSingleton() {
//    }

    public void printMessage(){
        System.out.println("Singleton Instance : "+ Instance.hashCode());
    }
}