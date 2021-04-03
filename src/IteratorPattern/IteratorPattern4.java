package IteratorPattern;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorPattern4 {
    public static void main(String[] args) {
        DataBase employeeDb = new EmployeeDataBase();
        EmployeeIterator employeeIterator = employeeDb.createIterator();
        while (employeeIterator.hasNext()) {
            System.out.println(employeeIterator.next());
        }
    }
}

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

interface DataBase {
    EmployeeIterator createIterator();
}

class EmployeeDataBase implements DataBase {
    private LinkedList<Employee> employees;

    public EmployeeDataBase() {
        employees = new LinkedList<>();
        employees.add(new Employee("Steven", 1, 1700.5));
        employees.add(new Employee("Kevin", 2, 4999.99));
        employees.add(new Employee("Katrien", 3, 2200));
        employees.add(new Employee("Kenny", 4, 6020.45));
    }

    @Override
    public EmployeeIterator createIterator() {
        return new EmployeeIterator(employees);
    }
}

class EmployeeIterator implements Iterator<Employee> {
    private final LinkedList<Employee> employees;
    private int position;

    public EmployeeIterator(LinkedList<Employee> employees) {
        this.employees = employees;
        position = 0;
    }

    public void first() {
        position = 0;
    }

    public Employee currentItem() {
        return employees.get(position);
    }

    @Override
    public boolean hasNext() {
        return position < employees.size();
    }

    @Override
    public Employee next() {
        return employees.get(position++);
    }
}