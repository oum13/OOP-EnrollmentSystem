package org.example.service;

import org.example.model.Course;

import java.util.ArrayList;

public interface CourseReg {
    void saveCourse(Course course);
    void display(int id);
    void updateCourse(int id);
    void removeCourse(int id);
    void displayAll();
    ArrayList<Course> getCourses();
}
