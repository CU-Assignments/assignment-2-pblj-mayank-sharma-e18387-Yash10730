import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    String name;
    int maxCapacity;
    List<String> enrolledStudents;
    String prerequisite;

    public Course(String name, int maxCapacity, String prerequisite) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.prerequisite = prerequisite;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enroll(String studentName, List<String> completedCourses)
            throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents.size() >= maxCapacity) {
            throw new CourseFullException("CourseFullException - No more seats available.");
        }

        if (prerequisite != null && !completedCourses.contains(prerequisite)) {
            throw new PrerequisiteNotMetException("PrerequisiteNotMetException - " + prerequisite + " not completed.");
        }

        enrolledStudents.add(studentName);
        System.out.println("Enrollment successful for: " + studentName);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course advancedJava = new Course("Advanced Java", 2, "Core Java");

        List<String> completedCourses = new ArrayList<>();
        // completedCourses.add("Core Java"); // Uncomment to simulate completion

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        try {
            advancedJava.enroll(name, completedCourses);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
