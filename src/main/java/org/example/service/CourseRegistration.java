package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Course> courses = new ArrayList<>();

    public void saveCourse(Course course){
        courses.add(course);
    }

    public void display(int index){
        if(courses.isEmpty()){
            System.out.println("No courses yet.");
            return;
        }

        courses.get(index).display();
    }

    public void updateCourse(int id){
        if(courses.isEmpty()){
            System.out.println("No courses yet.");
            return;
        }

        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getcourseID() == id){
                System.out.print("New Name: ");
                String name = scan.nextLine();

                System.out.print("New ID: ");
                int newId = scan.nextInt();
                scan.nextLine();

                System.out.print("New Program: ");
                String program = scan.nextLine();

                courses.get(i).setcourseName(name);
                courses.get(i).setcourseID(newId);
                courses.get(i).setProgram(program);

                System.out.println("Course updated successfully.");
                return;
            }
        }

        System.out.println("Course not found.");
    }

    public void removeCourse(int id){
        if(courses.isEmpty()){
            System.out.println("No courses yet.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getcourseID() == id) {
                courses.remove(i);
                System.out.println("Course with ID " + id + " removed.");
                return;
            }
        }

        System.out.println("Course not found.");
    }

    public void displayAll(){
        if(courses.isEmpty()){
            System.out.println("No courses yet.");
            return;
        }

        for(int i = 0; i < courses.size(); i++){
            courses.get(i).display();
        }
    }
}