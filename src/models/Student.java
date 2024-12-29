package models;

import java.util.*;

public class Student extends Person {
    private static int id_gen = 1;
    private int studentID;
    private List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = id_gen++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        double percentt = total / (double) grades.size();
        return (percentt / 100) * 4;
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ". GPA: " + String.format("%.2f", calculateGPA());
    }
}
