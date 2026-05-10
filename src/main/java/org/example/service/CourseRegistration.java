package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration implements CourseReg{
    Scanner scan = new Scanner(System.in);
    private ArrayList<Course> courses = new ArrayList<>();

    public void saveCourse(Course course){
        courses.add(course);
    }

    public void display(int id){
        for (Course course : courses) {
            if (course.getcourseID() == id) {
                course.display();
            }
        }
    }

    public void updateCourse(int id){
        for (Course course : courses) {
            if (course.getcourseID() == id) {
                System.out.print("New Name: ");
                String name = scan.nextLine();

                System.out.print("New ID: ");
                int newId = scan.nextInt();
                scan.nextLine();

                System.out.print("New Program: ");
                String program = scan.nextLine();

                course.setcourseName(name);
                course.setcourseID(newId);
                course.setProgram(program);

                System.out.println("Course updated successfully.");
                return;
            }
        }
    }

    public void removeCourse(int id){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getcourseID() == id) {
                courses.remove(i);
                System.out.println("Course with ID " + id + " removed.");
                return;
            }
        }
    }

    public void displayAll(){
        for (Course course : courses) {
            course.display();
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}