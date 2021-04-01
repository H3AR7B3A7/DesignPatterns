package CommandPattern;

public class CommandPattern3 {
    public static void main(String[] args) {
        Rcvr receiver = new Receiver1();
        Cmd command = new AdditionalCommand(receiver);
        Invkr invoker = new Invkr();
        invoker.setCommand(command);
        invoker.executeCommand();
        invoker.undoCommand();
        invoker.executeCommand();
        invoker.executeCommand();
        invoker.undoCommand();
        invoker.undoCommand();
        invoker.undoCommand();
        receiver = new Receiver2();
        command = new PowerCommand(receiver);
        invoker.setCommand(command);
        invoker.executeCommand();
        invoker.undoCommand();
        invoker.undoCommand();
    }
}

interface Cmd {
    void executeDo();

    void executeUndo();
}

class AdditionalCommand implements Cmd {
    private Rcvr rcvr;

    public AdditionalCommand(Rcvr rcvr) {
        this.rcvr = rcvr;
    }

    @Override
    public void executeDo() {
        rcvr.performDo();
    }

    @Override
    public void executeUndo() {
        rcvr.performUndo();
    }
}

class PowerCommand implements Cmd {
    private Rcvr rcvr;

    public PowerCommand(Rcvr rcvr) {
        this.rcvr = rcvr;
    }

    @Override
    public void executeDo() {
        rcvr.performDo();
    }

    @Override
    public void executeUndo() {
        rcvr.performUndo();
    }
}

interface Rcvr {
    void performDo();

    void performUndo();
}

class Receiver1 implements Rcvr {
    private int myNumber;

    public int getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }

    public Receiver1() {
        myNumber = 10;
        System.out.println("Receiver1 initialized with " + myNumber);
        System.out.println("The objects of receiver cannot set beyond " + myNumber);
    }

    @Override
    public void performDo() {
        System.out.println("Received an additional request...");
        int presentNumber = getMyNumber();
        setMyNumber(presentNumber + 2);
        System.out.println(presentNumber + " + 2 = " + myNumber);
    }

    @Override
    public void performUndo() {
        System.out.println("Received an undo additional request...");
        int presentNumber = getMyNumber();
        if (presentNumber > 10) {
            setMyNumber(presentNumber - 2);
            System.out.println(presentNumber + " - 2 = " + myNumber);
            System.out.println("Undo request processed.");
        } else {
            System.out.println("Nothing more to undo.");
        }
    }
}

class Receiver2 implements Rcvr {
    boolean status;

    public Receiver2() {
        System.out.println("Receiver2 initialized");
        status = false;
    }

    @Override
    public void performDo() {
        System.out.println("Received a system power on request...");
        if (!status) {
            System.out.println("System is starting up.");
            status = true;
        } else {
            System.out.println("System is already running.");
        }
    }

    @Override
    public void performUndo() {
        System.out.println("Received an undo request...");
        if (status) {
            System.out.println("Shutting down system.");
            status = false;
        } else {
            System.out.println("Powering up system again.");
            status = true;
        }
    }
}

class Invkr {
    private Cmd command;

    public void setCommand(Cmd command) {
        this.command = command;
    }

    public void executeCommand() {
        command.executeDo();
    }

    public void undoCommand() {
        command.executeUndo();
    }
}