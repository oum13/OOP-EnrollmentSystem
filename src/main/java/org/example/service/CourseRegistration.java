package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

import java.util.ArrayList;
import java.util.Scanner;
public class CourseRegistration {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Course> courses = new ArrayList<>();

    // Create
    public void saveCourse(Course course){
        courses.add(course);
    }

    // Read
    public void display(int index){
        if(courses.isEmpty()){
            System.out.println("No courses yet.");
        }
        System.out.println(courses.get(index).getcourseName());
        System.out.println(courses.get(index).getcourseID());
    }

    // Update
    public void updateCourse(int id){
        if(courses.isEmpty()){
            System.out.println("No courses yet.");
            return;
        }

        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getcourseID() == id){
                System.out.print("Name: ");
                String name = scan.nextLine();

                System.out.print("ID: ");
                id = scan.nextInt();

                courses.get(i).setcourseName(name);
                courses.get(i).setcourseID(id);

                System.out.println("Courses updated successfully.");
                return;
            }
        }
    }

    // Remove
    public void removeCourse(int id){
        if(courses.isEmpty()){
            System.out.println("No courses yet.");
        }
        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getcourseID() == id) {
                courses.remove(i);
                System.out.println("Person with ID " + id + " removed.");
                return;
            }
        }
    }

    // Display All
    public void displayAll(){
        for(int i = 0; i < courses.size(); i++){
            System.out.println("");
            System.out.println(courses.get(i).getcourseName());
            System.out.println(courses.get(i).getcourseID());
        }
    }
}

