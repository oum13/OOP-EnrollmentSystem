package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<>();

    public void saveStudent(Student student){
        students.add(student);
    }

    public void display(int index){
        if(students.isEmpty()){
            System.out.println("No students yet.");
            return;
        }

        students.get(index).display();
    }

    public void updateStudent(int id){
        if(students.isEmpty()){
            System.out.println("No students yet.");
            return;
        }

        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getID() == id){
                System.out.print("New Name: ");
                String name = scan.nextLine();

                System.out.print("New ID: ");
                int newId = scan.nextInt();
                scan.nextLine();

                System.out.print("New Program: ");
                String program = scan.nextLine();

                students.get(i).setName(name);
                students.get(i).setID(newId);
                students.get(i).setProgram(program);

                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void removeStudent(int id){
        if(students.isEmpty()){
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

    public void displayAll(){
        if(students.isEmpty()){
            System.out.println("No students yet.");
            return;
        }

        for(int i = 0; i < students.size(); i++){
            students.get(i).display();
        }
    }
}