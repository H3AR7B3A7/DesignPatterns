package StatePattern;

public class StatePattern2 {
    public static void main(String[] args) {
        TV tv = new TV();
        tv.pressOffButton();
        tv.pressMuteButton();
        tv.pressOnButton();
        tv.pressOnButton();
        tv.pressMuteButton();
        tv.pressMuteButton();
        tv.pressOffButton();
    }
}

interface PossibleState {
    void pressOnButton(TV context);

    void pressOffButton(TV context);

    void pressMuteButton(TV context);
}

class Off implements PossibleState {
    @Override
    public void pressOnButton(TV context) {
        System.out.println("You pressed 'ON', TV going to ON-state...");
        context.setCurrentState(context.getOnState());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public void pressOffButton(TV context) {
        System.out.println("You pressed 'OFF', TV is already off...");
    }

    @Override
    public void pressMuteButton(TV context) {
        System.out.println("You pressed 'MUTE', but TV is off...");
    }

    @Override
    public String toString() {
        return "*** TV is switched OFF now. ***";
    }
}

class On implements PossibleState {
    @Override
    public void pressOnButton(TV context) {
        System.out.println("You pressed 'ON', TV is already on...");
    }

    @Override
    public void pressOffButton(TV context) {
        System.out.println("You pressed 'OFF', TV going to OFF-state...");
        context.setCurrentState(context.getOffState());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public void pressMuteButton(TV context) {
        System.out.println("You pressed 'MUTE', muting TV...");
        context.setCurrentState(context.getMutedState());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public String toString() {
        return "*** TV is switched ON now. ***";
    }
}

class Mute implements PossibleState {
    @Override
    public void pressOnButton(TV context) {
        System.out.println("You pressed 'ON', TV is already on...");
    }

    @Override
    public void pressOffButton(TV context) {
        System.out.println("You pressed 'OFF', TV going to OFF-state...");
        context.setCurrentState(context.getOffState());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public void pressMuteButton(TV context) {
        System.out.println("You pressed 'MUTE' again, un-muting TV...");
        context.setCurrentState(context.getMutedState());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public String toString() {
        return "*** TV is now Muted. ***";
    }
}

class TV {
    private PossibleState currentState;
    private final PossibleState offState;
    private final PossibleState onState;
    private final PossibleState mutedState;

    public TV() {
        this.offState = new Off();
        this.onState = new On();
        this.mutedState = new Mute();
        this.currentState = offState;
    }

    public PossibleState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(PossibleState currentState) {
        this.currentState = currentState;
    }

    public void pressOffButton() {
        currentState.pressOffButton(this);
    }

    public void pressOnButton() {
        currentState.pressOnButton(this);
    }

    public void pressMuteButton() {
        currentState.pressMuteButton(this);
    }

    public PossibleState getOffState() {
        return offState;
    }

    public PossibleState getOnState() {
        return onState;
    }

    public PossibleState getMutedState() {
        return mutedState;
    }
}