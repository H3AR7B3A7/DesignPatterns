package ChainOfResponsibilityPattern;

public class ChainOfResponsibilityPattern2 {
    public static void main(String[] args) {
        Receiver faxHandler, emailHandler;
        IssueRaiser issueRaiser = new IssueRaiser();
        faxHandler = new FaxErrorHandler();
        emailHandler = new EmailErrorHandler();

        issueRaiser.setFirstErrorHandler(faxHandler);
        faxHandler.nextErrorHandler(emailHandler);
        emailHandler.nextErrorHandler(null);

        Message m1 = new Message("Fax is going slow.", MessagePriority.LOW);
        Message m2 = new Message("Emails are not reaching", MessagePriority.HIGH);
        Message m3 = new Message("In Email, CC field is always disabled.", MessagePriority.LOW);
        Message m4 = new Message("Fax is not reaching destinations.", MessagePriority.HIGH);

        issueRaiser.raiseMessage(m1);
        issueRaiser.raiseMessage(m2);
        issueRaiser.raiseMessage(m3);
        issueRaiser.raiseMessage(m4);
    }
}

enum MessagePriority {
    LOW,
    NORMAL,
    HIGH
}

class Message {
    public String text;
    public MessagePriority priority;

    public Message(String text, MessagePriority priority) {
        this.text = text;
        this.priority = priority;
    }
}

interface Receiver {
    boolean handleMessage(Message message);

    void nextErrorHandler(Receiver receiver);
}

class IssueRaiser {
    public Receiver setFirstReceiver;

    public void setFirstErrorHandler(Receiver firstErrorHandler) {
        this.setFirstReceiver = firstErrorHandler;
    }

    public void raiseMessage(Message message) {
        if (setFirstReceiver != null) {
            setFirstReceiver.handleMessage(message);
        }
    }
}

class FaxErrorHandler implements Receiver {
    private Receiver nextReceiver;

    @Override
    public boolean handleMessage(Message message) {
        if (message.text.contains("Fax")) {
            System.out.println("FaxErrorHandler processed " + message.priority + " priority issue: " + message.text);
            return true;
        } else {
            if (nextReceiver != null) {
                nextReceiver.handleMessage(message);
            }
        }
        return false;
    }

    @Override
    public void nextErrorHandler(Receiver nextReceiver) {
        this.nextReceiver = nextReceiver;
    }
}

class EmailErrorHandler implements Receiver {
    private Receiver nextReceiver;

    @Override
    public boolean handleMessage(Message message) {
        if (message.text.contains("Email")) {
            System.out.println("EmailErrorHandler processed " + message.priority + " priority issue: " + message.text);
            return true;
        } else {
            if (nextReceiver != null) {
                nextReceiver.handleMessage(message);
            }
        }
        return false;
    }

    @Override
    public void nextErrorHandler(Receiver nextReceiver) {
        this.nextReceiver = nextReceiver;
    }
}