package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentRegistration {
    Scanner scan = new Scanner(System.in);
    private ArrayList <Student> students = new ArrayList<>();

    // Create
    public void saveStudent(Student student){
        students.add(student);
    }

    // Read
    public void display(int index){
        if(students.isEmpty()){
            System.out.println("No students yet.");
        }
        System.out.println(students.get(index).getStudentName());
        System.out.println(students.get(index).getStudentID());
    }

    // Update
    public void updateStudent(int id){
        if(students.isEmpty()){
            System.out.println("No students yet.");
            return;
        }

        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentID() == id){
                System.out.print("Name: ");
                String name = scan.nextLine();

                scan.nextLine();

                System.out.print("ID: ");
                id = scan.nextInt();

                students.get(i).setName(name);
                students.get(i).setStudentID(id);

                System.out.println("Students updated successfully.");
                return;
            }
        }
    }

    // Remove
    public void removeStudent(int id){
        if(students.isEmpty()){
            System.out.println("No students yet.");
        }
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentID() == id) {
                students.remove(i);
                System.out.println("Person with ID " + id + " removed.");
                return;
            }
        }
    }

    // Display All
    public void displayAll(){
        for(int i = 0; i < students.size(); i++){
            System.out.println("");
            System.out.println(students.get(i).getStudentName());
            System.out.println(students.get(i).getStudentID());
        }
    }
}
