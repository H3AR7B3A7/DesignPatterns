package MementoPattern;

public class MementoPattern2 {
    public static void main(String[] args) {
        Originator2 originator = new Originator2();
        Memento2 memento;
        originator.setStateId(1);
        memento = originator.saveMemento(originator.getStateId());
        originator.setStateId(5);
        System.out.println(originator.getStateId());
        originator.revertMemento(memento);
        System.out.println(originator.getStateId());
    }
}

class Memento2 {
    private final int stateId;

    public Memento2(int stateId) {
        this.stateId = stateId;
    }

    public int getStateId() {
        return stateId;
    }
}

class Originator2 {
    private int stateId;

    public Originator2() {
        this.stateId = 0;
        System.out.println("Originator created with state id: " + stateId);
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        System.out.println("Setting originator state id to: " + stateId);
        this.stateId = stateId;
    }

    public Memento2 saveMemento(int stateId) {
        System.out.println("Saving originator current state...");
        return new Memento2(stateId);
    }

    public void revertMemento(Memento2 previousMemento) {
        System.out.println("Restoring to state id: " + previousMemento.getStateId());
        this.stateId = previousMemento.getStateId();
        System.out.println("Current state id of originator: " + stateId);
    }
}