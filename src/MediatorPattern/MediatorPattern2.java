package MediatorPattern;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MediatorPattern2 {
    public static void main(String[] args) throws InterruptedException {
        ConcreteMediatior mediator = new ConcreteMediatior();

        JuniorEmployee steven = new JuniorEmployee(mediator, "Steven");
        JuniorEmployee britt = new JuniorEmployee(mediator, "Britt");
        SeniorEmployee kevin = new SeniorEmployee(mediator, "Kevin");

        mediator.register(steven);
        mediator.register(britt);
        mediator.register(kevin);

        mediator.displayRegisteredEmployees();

        steven.sendMessage("Hi!");
        britt.sendMessage("Hello guys.");
        kevin.sendMessage("Hi everyone.");

        Unknown unknown = new Unknown(mediator, "Kenny");
        unknown.sendMessage("Peekaboo!");
    }
}

interface Mediator {
    void register(Employee employee);

    void sendMessage(Employee employee, String msg) throws InterruptedException;
}

class ConcreteMediatior implements Mediator {
    List<Employee> participants = new ArrayList<>();

    public void displayRegisteredEmployees() {
        System.out.println("registered participants:");
        for (Employee employee : participants) {
            System.out.println(employee.getName());
        }
    }

    @Override
    public void register(Employee employee) {
        participants.add(employee);
    }

    @Override
    public void sendMessage(Employee employee, String msg) throws InterruptedException {
        if (participants.contains(employee)) {
            System.out.println("[" + LocalDateTime.now() + "] " + employee.getName() + " posts: " + msg);
            Thread.sleep(1000);
        } else {
            System.out.println("An outsider named " + employee.getName() + " is trying to send some message.");
        }
    }
}

abstract class Employee {
    protected Mediator mediator;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String msg) throws InterruptedException {
        mediator.sendMessage(this, msg);
    }

    public abstract String employeeType();
}

class JuniorEmployee extends Employee {
    public JuniorEmployee(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public String employeeType() {
        return "Junior Employee";
    }
}

class SeniorEmployee extends Employee {
    public SeniorEmployee(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public String employeeType() {
        return "Senior Employee";
    }
}

class Unknown extends Employee {
    public Unknown(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public String employeeType() {
        return "Outsider";
    }
}