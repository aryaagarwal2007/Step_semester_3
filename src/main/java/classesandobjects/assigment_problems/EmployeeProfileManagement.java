package classesandobjects.assigment_problems;

/**
 * M3: Employee Profile Creation
 *
 * NOTE: the problem statement's suggested class name is "Employee", but M5 in
 * this same assignment set also defines a class called "Employee" with
 * different fields. Since both would live in the same package, the class
 * here is named EmployeeProfile instead to avoid a duplicate-class compile
 * error. All fields, constructors and behavior match the problem exactly.
 *
 * The intern constructor chains to the permanent-employee constructor via
 * this(...) with salary defaulted to 0, then sets isIntern to true afterwards.
 */
public class EmployeeProfileManagement {
    public static void main(String[] args) {
        EmployeeProfile permanent = new EmployeeProfile("E-101", "Divya", 65000);
        EmployeeProfile intern = new EmployeeProfile("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}

class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}
