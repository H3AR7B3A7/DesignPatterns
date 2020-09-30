/**
 * Double-Checked Locking
 */
public class DoubleCheckedLockingPattern {
    public static void main(String[] args){
        DoubleCheckedLockingSingleton singleton = DoubleCheckedLockingSingleton.getInstance();
        singleton.printMessage();

        DoubleCheckedLockingSingleton singleton2 = DoubleCheckedLockingSingleton.getInstance();
        singleton2.printMessage();
    }
}

class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance = null;

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class)
            {
                if (instance == null)
                {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    private DoubleCheckedLockingSingleton(){}

    public void printMessage(){
        System.out.println("Inside Singleton function. Singleton Instance: "+this.hashCode());
    }
}