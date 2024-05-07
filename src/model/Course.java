package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    String courseName;
    String professorName;
    int year;
    List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
        this.enrolledStudents = new ArrayList<>();
    }

    // Methods
    public void enroll(Student student) {
        enrolledStudents.add(student);
    }

    public void enroll(Student[] students) {
        for (Student student : students) {
            enroll(student);
        }
    }

    public void unEnroll(Student student) {
        enrolledStudents.remove(student);
    }

    public int countStudents() {
        return enrolledStudents.size();
    }

    public int bestGrade() {
        int maxGrade = 0;
        for (Student student : enrolledStudents) {
            if (student.grade > maxGrade) {
                maxGrade = student.grade;
            }
        }
        return maxGrade;
    }

    public double averageGrade() {
        if (enrolledStudents.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Student student : enrolledStudents) {
            sum += student.grade;
        }
        return (double) sum / enrolledStudents.size();
    }

    public void displayRanking() {
        enrolledStudents.sort((s1, s2) -> s2.grade - s1.grade);
        System.out.println("Ranking for " + courseName + ":");
        for (int i = 0; i < enrolledStudents.size(); i++) {
            System.out.println((i + 1) + ". " + enrolledStudents.get(i).firstName + " " + enrolledStudents.get(i).lastName + ": " + enrolledStudents.get(i).grade);
        }
    }

    public void showAboveAverage() {
        double average = averageGrade();
        System.out.println("Students above average in " + courseName + ":");
        for (Student student : enrolledStudents) {
            if (student.grade > average) {
                System.out.println(student.firstName + " " + student.lastName + ": " + student.grade);
            }
        }
    }
}