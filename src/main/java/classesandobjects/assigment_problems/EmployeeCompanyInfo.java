package classesandobjects.assigment_problems;

/**
 * M5: Employee and Company Information Management
 *
 * companyName and employeeCount are static — shared across every Employee
 * object instead of duplicated per instance. printCompanyInfo() touches only
 * static state, so it's called through the class name, not an object.
 */
public class EmployeeCompanyInfo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Asha", 40000);
        Employee e2 = new Employee("Vikram", 42000);
        Employee e3 = new Employee("Neha", 38000);

        System.out.println(Employee.employeeCount + " Employee objects created");
        Employee.printCompanyInfo();
    }
}

class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
