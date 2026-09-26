package classesandobjects.class_problems;

/**
 * M5: Student and College Information Management
 *
 * collegeName and studentCount are static — shared by every Student object
 * instead of being duplicated per instance. printCollegeInfo() only touches
 * static state, so it's called through the class name, not an object.
 */
public class Student {
    String name;
    int attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 95);

        System.out.println(studentCount + " Student objects created");
        Student.printCollegeInfo();
    }
}
