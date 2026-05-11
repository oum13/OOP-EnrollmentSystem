package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration implements StudentReg {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<>();

    public void saveStudent(Student student) {
        students.add(student);
    }

    public void display(int id) {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == id) {
                Student s = students.get(i);
                System.out.println("Student ID: " + s.getID());
                System.out.println("Student Name: " + s.getName());
                System.out.println("Student Program: " + s.getProgram());
                System.out.println();
            }
        }
    }

    public void updateStudent(int id) {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }

        for (Student student : students) {
            if (student.getID() == id) {
                System.out.print("New Name: ");
                String name = scan.nextLine();

                System.out.print("New ID: ");
                int newId = scan.nextInt();
                scan.nextLine();

                System.out.print("New Program: ");
                String program = scan.nextLine();

                student.setName(name);
                student.setID(newId);
                student.setProgram(program);

                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void removeStudent(int id) {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == id) {
                students.remove(i);
                System.out.println("Student with ID " + id + " removed.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }

        for (Student student : students) {
            System.out.println("Student ID: " + student.getID());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Program: " + student.getProgram());
            System.out.println();
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}