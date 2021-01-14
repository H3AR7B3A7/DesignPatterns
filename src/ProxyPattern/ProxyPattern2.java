package ProxyPattern;

public class ProxyPattern2 {
    public static void main(String[] args) {
        Proxy proxy1 = new Proxy();
        proxy1.doSomeWork();
        proxy1.doSomeWork();
        System.out.println(Proxy.count);

        Proxy proxy2 = new Proxy();
        proxy2.doSomeWork();
        System.out.println(Proxy.count);
    }
}

abstract class Subject{
    public abstract void doSomeWork();
}

class ConcreteSubject extends Subject {
    @Override
    public void doSomeWork() {
        System.out.println("Working...");
    }
}

class Proxy extends Subject {
    static Subject subject;
    static int count = 0;

//    public Proxy() {
//        subject = new ConcreteSubject();
//        count++;
//    }

    @Override
    public void doSomeWork() {
        System.out.println("Calling proxy...");
        if (subject == null){
            subject = new ConcreteSubject();
            count++;
        }
        subject.doSomeWork();
    }
}