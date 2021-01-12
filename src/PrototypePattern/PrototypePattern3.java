package PrototypePattern;

public class PrototypePattern3 {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Steven");
        Student student2 = new Student(2, "Britt");

        Student clone1 = new Student(student1);
        Student clone2 = new Student(student2);

        clone1.getDetails();
        clone2.getDetails();
    }
}

class Student {
    private final int number;
    private final String name;

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Student(Student student) {
        this.number = student.number;
        this.name = student.name;
    }

    public void getDetails() {
        System.out.println(number + ": " + name);
    }
}
