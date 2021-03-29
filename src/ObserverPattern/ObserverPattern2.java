package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern2 {
    public static void main(String[] args) {
        Observer myObserver1 = new ObserverType1("Roy");
        Observer myObserver2 = new ObserverType1("Kevin");
        Observer myObserver3 = new ObserverType2("Bose");
        Subject subject = new Subject();
        subject.register(myObserver1);
        subject.register(myObserver2);
        subject.register(myObserver3);
        System.out.println("Setting flag:");
        subject.setFlag(5);
        subject.unregister(myObserver1);
        System.out.println("Setting flag again:");
        subject.setFlag(25);
    }
}

interface Observer {
    void update(int updatedValue);
}

class ObserverType1 implements Observer {
    String nameOfObserver;

    public ObserverType1(String nameOfObserver) {
        this.nameOfObserver = nameOfObserver;
    }

    @Override
    public void update(int updatedValue) {
        System.out.println(nameOfObserver + " has received an alert: Updated myValue in Subject is: " + updatedValue);
    }
}

class ObserverType2 implements Observer {
    String nameOfObserver;

    public ObserverType2(String nameOfObserver) {
        this.nameOfObserver = nameOfObserver;
    }

    @Override
    public void update(int updatedValue) {
        System.out.println(nameOfObserver + " has received an alert: The current value of myValue in Subject is: " + updatedValue);
    }
}

interface SubjectInterface {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyRegisteredUsers(int notifiedValue);
}

class Subject implements SubjectInterface {
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        notifyRegisteredUsers(flag);
    }

    List<Observer> observerList = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyRegisteredUsers(int updatedValue) {
        for (Observer o : observerList) {
            o.update(updatedValue);
        }
    }
}