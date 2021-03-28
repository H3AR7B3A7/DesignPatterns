package BridgePattern;

public class BridgePattern2 {
    public static void main(String[] args) {
        System.out.println("Television:");
        State presentState = new OffState();
        ElectronicGoods electronicGoods = new Television();
        electronicGoods.setState(presentState);
        electronicGoods.moveToCurrentState();
        electronicGoods.hardButtonPressed();

        presentState = new OnState();
        electronicGoods.setState(presentState);
        electronicGoods.moveToCurrentState();

        presentState = new OffState();
        electronicGoods = new DVD();
        electronicGoods.setState(presentState);
        electronicGoods.moveToCurrentState();
        electronicGoods.hardButtonPressed();
        ((DVD) electronicGoods).doublePress();

        presentState = new OnState();
        electronicGoods.setState(presentState);
        electronicGoods.moveToCurrentState();
        electronicGoods.hardButtonPressed();
        ((DVD) electronicGoods).doublePress();
    }
}

interface State {
    void moveState();

    void hardPressed();
}

class OnState implements State {
    @Override
    public void moveState() {
        System.out.println("ON");
    }

    @Override
    public void hardPressed() {
        System.out.println("\tThe device is on. Do not press the button so hard.");
    }
}

class OffState implements State {
    @Override
    public void moveState() {
        System.out.println("OFF");
    }

    @Override
    public void hardPressed() {
        System.out.println("\tThe device is off. Do not press the button so hard.");
    }
}

abstract class ElectronicGoods {
    protected State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void moveToCurrentState() {
        System.out.println("The electronic item is functioning at: ");
        state.moveState();
    }

    public void hardButtonPressed() {
        state.hardPressed();
    }
}

class Television extends ElectronicGoods {
}

class DVD extends ElectronicGoods {
    public void doublePress() {
        hardButtonPressed();
        hardButtonPressed();
    }
}