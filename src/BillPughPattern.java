/**
 * Bill Pugh's
 */
public class BillPughPattern {
    public static void main(String[] args){
        BillPughSingleton singleton = BillPughSingleton.getInstance();
        singleton.printMessage();

        BillPughSingleton singleton2 = BillPughSingleton.getInstance();
        singleton2.printMessage();
    }
}

class BillPughSingleton {
    private static class BillPughSingletonHolder {
        public static final BillPughSingleton INSTANCE = new BillPughSingleton();

    }
    public static BillPughSingleton getInstance() {
        return BillPughSingletonHolder.INSTANCE;
    }

    public void printMessage(){
        System.out.println("Inside Singleton function. Singleton Instance: "+this.hashCode());
    }
}
