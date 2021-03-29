package VisitorPattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern2 {
    public static void main(String[] args) {
        SimpleEmployee employee1 = new SimpleEmployee("Kenneth", "maintenance", 2);
        SimpleEmployee employee2 = new SimpleEmployee("Bert", "maintenance", 5);
        SimpleEmployee employee3 = new SimpleEmployee("Ernie", "maintenance", 6);

        SimpleEmployee employee4 = new SimpleEmployee("Steven", "IT", 0);
        SimpleEmployee employee5 = new SimpleEmployee("Isabelle", "IT", 6);

        CompositeEmployee employee6 = new CompositeEmployee("Katrien", "HR", 6);
        CompositeEmployee employee7 = new CompositeEmployee("Kevin", "IT", 20);
        CompositeEmployee employee8 = new CompositeEmployee("Kenny", "management", 20);

        employee6.addEmployee(employee1);
        employee6.addEmployee(employee2);
        employee6.addEmployee(employee3);

        employee7.addEmployee(employee4);
        employee7.addEmployee(employee5);

        employee8.addEmployee(employee6);
        employee8.addEmployee(employee7);

        employee8.printStructures();

        Visitor2 visitor = new ConcreteVisitor2();

        List<Employee> employeeContainer = new ArrayList<>(employee8.getSubordinates());
        employeeContainer.addAll(employee7.getSubordinates());
        employeeContainer.addAll(employee6.getSubordinates());

        for (Employee emp : employeeContainer) {
            emp.acceptVisitor(visitor);
        }
    }
}

interface Employee {
    void printStructures();

    void acceptVisitor(Visitor2 visitor);
}

class CompositeEmployee implements Employee {
    private String name;
    private String dept;
    private final int yearsOfExperience;
    private List<Employee> subordinates;

    public CompositeEmployee(String name, String dept, int yearsOfExperience) {
        this.name = name;
        this.dept = dept;
        this.yearsOfExperience = yearsOfExperience;
        subordinates = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        subordinates.add(emp);
    }

    public void removeEmployee(Employee emp) {
        subordinates.remove(emp);
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public void printStructures() {
        System.out.println("\t" + getName() + " works in " + getDept() + ", Experience: " + getYearsOfExperience() + " years");
        for (Employee emp : subordinates) {
            emp.printStructures();
        }
    }

    @Override
    public void acceptVisitor(Visitor2 visitor) {
        visitor.visitTheElement(this);
    }
}

class SimpleEmployee implements Employee {
    private String name;
    private String dept;
    private final int yearsOfExperience;

    public SimpleEmployee(String name, String dept, int yearsOfExperience) {
        this.name = name;
        this.dept = dept;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public void printStructures() {
        System.out.println("\t" + getName() + " works in " + getDept() + ", Experience: " + getYearsOfExperience() + " years");
    }

    @Override
    public void acceptVisitor(Visitor2 visitor) {
        visitor.visitTheElement(this);
    }
}

interface Visitor2 {
    void visitTheElement(CompositeEmployee compositeEmployee);

    void visitTheElement(SimpleEmployee simpleEmployee);
}

class ConcreteVisitor2 implements Visitor2 {
    @Override
    public void visitTheElement(CompositeEmployee employee) {
        boolean eligibleForPromotion = employee.getYearsOfExperience() > 10;
        System.out.println("\t\t" + employee.getName() + " from " + employee.getDept() + " is eligible for promotion? " + eligibleForPromotion);
    }

    @Override
    public void visitTheElement(SimpleEmployee employee) {
        boolean eligibleForPromotion = employee.getYearsOfExperience() > 5;
        System.out.println("\t\t" + employee.getName() + " from " + employee.getDept() + " is eligible for promotion? " + eligibleForPromotion);
    }
}
