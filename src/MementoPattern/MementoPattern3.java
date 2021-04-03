package MementoPattern;

public class MementoPattern3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        EmpAddress empAddress = new EmpAddress("1, AbcRoad, USA");
        Employee emp = new Employee(1, "Steven", empAddress);
        System.out.println(emp);
        Employee empClone = (Employee) emp.clone();
        System.out.println(empClone);
        emp.empAddress.setAddress("2, OtherRoad, Netherlands");
        emp.setId(2);
        emp.setName("Kevin");
        System.out.println(emp);
        System.out.println(empClone);
    }
}

class EmpAddress implements Cloneable {
    String address;

    public EmpAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmpAddress{" +
                "address='" + address + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Employee implements Cloneable {
    int id;
    String name;
    EmpAddress empAddress;

    public Employee(int id, String name, EmpAddress empAddress) {
        this.id = id;
        this.name = name;
        this.empAddress = empAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmpAddress getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(EmpAddress empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empAddress=" + empAddress +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Shallow copy:
        // return super.clone();
        Employee employee = (Employee) super.clone();
        employee.empAddress = (EmpAddress) empAddress.clone();
        return employee;
    }
}