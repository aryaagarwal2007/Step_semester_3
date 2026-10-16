package data_structure.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            // Input line looks like: Asha [80, 90, 70]
            int bracket = line.indexOf('[');
            String name = line.substring(0, bracket).trim();
            String[] parts = line.substring(bracket + 1, line.indexOf(']')).split(",");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) marks[i] = Integer.parseInt(parts[i].trim());

            Student s = new Student(name, marks);
            System.out.println(String.format(Locale.US, "%s: Average %.1f, Grade %c",
                    s.getName().toUpperCase(), s.calculateAverage(), s.getGrade()));
        }
    }
}

class Student {
    private final String name;
    private final int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() { return name; }

    double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    char getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
}
