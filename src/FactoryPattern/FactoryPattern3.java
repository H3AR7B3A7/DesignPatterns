package FactoryPattern;

public class FactoryPattern3 {
    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }

    public static void serviceConsumer(ServiceFactory serviceFactory) {
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }
}

interface Service {

    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {
    }

    @Override
    public void method1() {
        System.out.println("Implementation 1 : Method 1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation 1 : Method 2");
    }

    /**
     * LAMBDA (SHORT FOR AN ANONYMOUS INNER CLASS - SEE BELOW)
     */
    public static ServiceFactory factory =
            () -> new Implementation1();
}

class Implementation2 implements Service {
    private Implementation2() {
    }

    @Override
    public void method1() {
        System.out.println("Implementation 2 : Method 1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation 2 : Method 2");
    }

    /**
     * ANONYMOUS INNER CLASS
     */
    public static ServiceFactory factory =
            new ServiceFactory() {
                @Override
                public Service getService() {
                    return new Implementation2();
                }
            };
}