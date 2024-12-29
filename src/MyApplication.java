import models.Person;
import models.School;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        File studentFile = new File("src/students.txt");
        Scanner sc = new Scanner(studentFile);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner lineScanner = new Scanner(line);

            String name = lineScanner.next();
            String surname = lineScanner.next();
            int age = lineScanner.nextInt();
            boolean gender = lineScanner.next().equalsIgnoreCase("Male");

            Student student = new Student(name, surname, age, gender);

            while (lineScanner.hasNextInt()) {
                student.addGrade(lineScanner.nextInt());
            }

            school.addMember(student);
            lineScanner.close();
        }

        sc.close();
        File teacherFile = new File("src/teachers.txt");
        Scanner scTeacher = new Scanner(teacherFile);

        while (scTeacher.hasNextLine()) {
            String line = scTeacher.nextLine();
            Scanner lineScanner = new Scanner(line);

            String name = lineScanner.next();
            String surname = lineScanner.next();
            int age = lineScanner.nextInt();
            boolean gender = lineScanner.next().equalsIgnoreCase("Male");
            String subject = lineScanner.next();
            int yearsOfExperience = lineScanner.nextInt();
            int salary = lineScanner.nextInt();

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            if (teacher.getYearsOfExperience() > 10) {
                teacher.giveRaise(10);
            }

            school.addMember(teacher);
            lineScanner.close();
        }

        scTeacher.close();

        System.out.println(school);
 }
}