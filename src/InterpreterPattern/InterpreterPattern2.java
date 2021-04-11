package InterpreterPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterpreterPattern2 {
    public static void main(String[] args) {
        Context context = new Context(10, "G2", "G3");

        Employee employee1 = new IndividualEmployee(5, "G1");
        Employee employee2 = new IndividualEmployee(10, "G2");
        Employee employee3 = new IndividualEmployee(15, "G3");
        Employee employee4 = new IndividualEmployee(20, "G4");

        EmployeeBuilder builder = new EmployeeBuilder();

        System.out.println("Employee 1 is ready for promotion. " + employee1.interpret(context));
        System.out.println("Employee 2 is ready for promotion. " + employee2.interpret(context));
        System.out.println("Employee 3 is ready for promotion. " + employee3.interpret(context));
        System.out.println("Employee 4 is ready for promotion. " + employee4.interpret(context));

        System.out.println("Is eiter employee 1 or 2 eligible for promotion? " + builder.buildExpression(employee1, "OR", employee2).interpret(context));
        System.out.println("Is eiter employee 2 and 4 eligible for promotion? " + builder.buildExpression(employee2, "AND", employee4).interpret(context));
        System.out.println("Is employee 3 'not' eligible for promotion? " + builder.buildExpression(employee3, "NOT", null).interpret(context));
        System.out.println("Wrong operator given: " + builder.buildExpression(employee1, "Wrong", employee2));
    }
}

interface Employee {
    boolean interpret(Context context);
}

class IndividualEmployee implements Employee {
    private final int yearsOfExperience;
    private final String currentGrade;

    public IndividualEmployee(int yearsOfExperience, String currentGrade) {
        this.yearsOfExperience = yearsOfExperience;
        this.currentGrade = currentGrade;
    }

    @Override
    public boolean interpret(Context context) {
        return this.yearsOfExperience >= context.getYearsOfExperience() && context.getPermissibleGrades().contains(this.currentGrade);
    }
}

class OrExpression2 implements Employee {
    private final Employee emp1;
    private final Employee emp2;

    public OrExpression2(Employee emp1, Employee emp2) {
        this.emp1 = emp1;
        this.emp2 = emp2;
    }

    @Override
    public boolean interpret(Context context) {
        return emp1.interpret(context) || emp2.interpret(context);
    }
}

class AndExpression2 implements Employee {
    private final Employee emp1;
    private final Employee emp2;

    public AndExpression2(Employee emp1, Employee emp2) {
        this.emp1 = emp1;
        this.emp2 = emp2;
    }

    @Override
    public boolean interpret(Context context) {
        return emp1.interpret(context) && emp2.interpret(context);
    }
}

class NotExpression2 implements Employee {
    private Employee emp;

    public NotExpression2(Employee emp) {
        this.emp = emp;
    }

    @Override
    public boolean interpret(Context context) {
        return !emp.interpret(context);
    }
}

class Context {
    private final int yearsOfExperience;
    private final List<String> permissibleGrades;

    public Context(int yearsOfExperience, String... allowedGrades) {
        this.yearsOfExperience = yearsOfExperience;
        this.permissibleGrades = new ArrayList<>();
        Collections.addAll(permissibleGrades, allowedGrades);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public List<String> getPermissibleGrades() {
        return permissibleGrades;
    }
}

class EmployeeBuilder {
    public Employee buildExpression(Employee emp1, String operator, Employee emp2) {
        switch (operator.toLowerCase()) {
            case "or":
                return new OrExpression2(emp1, emp2);
            case "and":
                return new AndExpression2(emp1, emp2);
            case "not":
                return new NotExpression2(emp1);
            default:
                System.out.println("Only AND, OR and NOT operators are allowed.");
                return null;
        }
    }
}