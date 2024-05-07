import model.Course;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Doe", 1, 70, 1);
        Student student2 = new Student("Alice", "Smith", 2, 55, 1);
        Student student3 = new Student("Bob", "Johnson", 3, 80, 1);

        Course mathCourse = new Course("Math", "Prof. Brown", 2024);

        mathCourse.enroll(new Student[]{student1, student2, student3});

        System.out.println("Number of students enrolled: " + mathCourse.countStudents());
        System.out.println("Best grade in the course: " + mathCourse.bestGrade());
        System.out.println("Average grade in the course: " + mathCourse.averageGrade());

        mathCourse.displayRanking();
        mathCourse.showAboveAverage();
    }
}




