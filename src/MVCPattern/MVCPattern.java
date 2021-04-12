package MVCPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MVCPattern {
    public static void main(String[] args) {
        Model model = new EmployeeModel();
        View view = new ConsoleView();

        Controller controller = new EmployeeController(model, view);
        controller.addEmployee(new Employee("Steven", "A1"));
        controller.addEmployee(new Employee("Kevin", "A2"));
        controller.displayEnrolledEmployees();
        controller.removeEmployee("A1");
        controller.displayEnrolledEmployees();
        controller.addEmployee(new Employee("Kevin", "A2"));
    }
}

class Employee {
    private final String empName;
    private final String empId;

    public Employee(String empName, String empId) {
        this.empName = empName;
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return "Employee " + empName + " (with id: " + empId + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee empObject = (Employee) o;
        if (!empName.equals(empObject.empName)) return false;
        if (!empId.equals(empObject.empId)) return false;
        return true;
    }
}

interface Model {
    List<Employee> getEnrolledEmployeeDetailsFromModel();

    void addEmployeeToModel(Employee employee);

    void removeEmployeeFromModel(String employeeId);
}

class EmployeeModel implements Model {
    List<Employee> enrolledEmployees;

    public EmployeeModel() {
        enrolledEmployees = new ArrayList<>();
        enrolledEmployees.add(new Employee("Steven", "E1"));
        enrolledEmployees.add(new Employee("Kevin", "E2"));
        enrolledEmployees.add(new Employee("Britt", "E3"));
    }

    @Override
    public List<Employee> getEnrolledEmployeeDetailsFromModel() {
        return enrolledEmployees;
    }

    @Override
    public void addEmployeeToModel(Employee employee) {
        System.out.println("Trying to add new employee: ");
        if (!enrolledEmployees.contains(employee)) {
            enrolledEmployees.add(employee);
            System.out.println(employee + " was added!");
        } else {
            System.out.println(employee + " was already enrolled.");
        }
    }

    @Override
    public void removeEmployeeFromModel(String employeeId) {
        boolean flag = false;
        ListIterator<Employee> employeeListIterator = enrolledEmployees.listIterator();
        System.out.println("Trying to remove an employee: ");
        while (employeeListIterator.hasNext()) {
            Employee removableEmployee = ((Employee) employeeListIterator.next());
            if (removableEmployee.getEmpId().equals(employeeId)) {
                employeeListIterator.remove();
                System.out.println(removableEmployee.toString() + " was removed.");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Couldn't find employee to be removed.");
        }
    }
}

interface View {
    void showEnrolledEmployees(List<Employee> enrolledEmployees);
}

class ConsoleView implements View {
    @Override
    public void showEnrolledEmployees(List<Employee> enrolledEmployees) {
        System.out.println("*** Currently enrolled: ***");
        for (Employee emp : enrolledEmployees) {
            System.out.println(emp);
        }
        System.out.println("______________________");
    }
}

interface Controller {
    void displayEnrolledEmployees();

    void addEmployee(Employee employee);

    void removeEmployee(String employeeId);
}

class EmployeeController implements Controller {
    private final Model model;
    private final View view;

    public EmployeeController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void displayEnrolledEmployees() {
        List<Employee> enrolledEmployees = model.getEnrolledEmployeeDetailsFromModel();
        view.showEnrolledEmployees(enrolledEmployees);
    }

    @Override
    public void addEmployee(Employee employee) {
        model.addEmployeeToModel(employee);
    }

    @Override
    public void removeEmployee(String employeeId) {
        model.removeEmployeeFromModel(employeeId);
    }
}