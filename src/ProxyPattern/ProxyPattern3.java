package ProxyPattern;

import java.util.ArrayList;
import java.util.List;

public class ProxyPattern3 {
    public static void main(String[] args) {
        MyProxy proxy1 = new MyProxy("Admin");
        proxy1.doSomeWork();
        MyProxy proxy2 = new MyProxy("Brat");
        proxy2.doSomeWork();
    }
}

abstract class Topic {
    public abstract void doSomeWork();
}

class ConcreteTopic extends Topic {
    @Override
    public void doSomeWork() {
        System.out.println("doSomeWork() inside ConcreteTopic is invoked.");
    }
}

class MyProxy extends Topic {
    static Topic topic;
    String currentUser;
    List<String> registeredUsers;

    public MyProxy(String currentUser) {
        registeredUsers = new ArrayList<>();
        registeredUsers.add("Admin");
        registeredUsers.add("Sam");
        registeredUsers.add("Johny");
        this.currentUser = currentUser;
    }

    @Override
    public void doSomeWork() {
        System.out.println("Proxy call happening now ...");
        System.out.println(currentUser + " wants to invoke a proxy method.");
        if(registeredUsers.contains(currentUser)){
            if(topic == null){
                topic = new ConcreteTopic();
            }
            topic.doSomeWork();
        } else {
            System.out.println("Sorry " + currentUser + ", you do not have access rights.");
        }
    }
}