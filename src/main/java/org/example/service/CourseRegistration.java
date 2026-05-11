package org.example.service;

import org.example.customexception.DuplicateCourseIDException;
import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration implements CourseReg {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Course> courses = new ArrayList<>();

    @Override
    public void saveCourse(Course course) throws DuplicateCourseIDException {
        for (Course c : courses) {
            if (c.getcourseID() == course.getcourseID()) {
                throw new DuplicateCourseIDException(course.getcourseID());
            }
        }
        courses.add(course);
        System.out.println("Course \"" + course.getcourseName() + "\" registered successfully.");
    }

    @Override
    public void display(int id) {
        for (Course course : courses) {
            if (course.getcourseID() == id) {
                System.out.println("Course ID: " + course.getcourseID());
                System.out.println("Course Name: " + course.getcourseName());
                System.out.println("Program: " + course.getProgram());
                System.out.println();
            }
        }
    }

    @Override
    public void updateCourse(int id) {
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

    @Override
    public void removeCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getcourseID() == id) {
                courses.remove(i);
                System.out.println("Course with ID " + id + " removed.");
                return;
            }
        }
    }

    @Override
    public void displayAll() {
        for (Course course : courses) {
            System.out.println("Course ID: " + course.getcourseID());
            System.out.println("Course Name: " + course.getcourseName());
            System.out.println("Program: " + course.getProgram());
            System.out.println();
        }
    }

    @Override
    public ArrayList<Course> getCourses() {
        return courses;
    }
}