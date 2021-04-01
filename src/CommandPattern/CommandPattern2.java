package CommandPattern;

public class CommandPattern2 {
    public static void main(String[] args) {
        MyReceiver receiver = new MyReceiver();
        UndoCommand undo = new UndoCommand(receiver);
        Invoker invoker = new Invoker(undo);
        invoker.invokeCommand();
        RedoCommand redo = new RedoCommand(receiver);
        invoker.setCommand(redo);
        invoker.invokeCommand();
    }
}

interface Command {
    void execute();
}

class UndoCommand implements Command {
    private final MyReceiver receiver;

    public UndoCommand(MyReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.performUndo();
    }
}

class RedoCommand implements Command {
    private final MyReceiver receiver;

    public RedoCommand(MyReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doOptionalTaskPriorToRedo();
        receiver.performRedo();
    }
}

class MyReceiver {
    public void performUndo() {
        System.out.println("Rolling back in receiver...");
    }

    public void performRedo() {
        System.out.println("Redoing roll back in receiver...");
    }

    public void doOptionalTaskPriorToRedo() {
        System.out.println("Performing some optional task...");
    }
}

class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invokeCommand() {
        command.execute();
    }
}