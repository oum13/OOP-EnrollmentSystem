package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

import java.util.ArrayList;

public class CampusRegistrar {
    private StudentReg studentReg;
    private CourseReg courseReg;
    private TuitionFP tuitionFP;

    public CampusRegistrar(StudentReg studentReg, CourseReg courseReg, TuitionFP tuitionFP) {
        this.studentReg = studentReg;
        this.courseReg = courseReg;
        this.tuitionFP = tuitionFP;
    }

    public void saveStudent(Student student) {
        studentReg.saveStudent(student);
    }

    public void displayStudent(int id) {
        studentReg.display(id);
    }

    public void updateStudent(int id) {
        studentReg.updateStudent(id);
    }

    public void removeStudent(int id) {
        studentReg.removeStudent(id);
    }

    public void displayAllStudents() {
        studentReg.displayAll();
    }

    public ArrayList<Student> getStudents() {
        return studentReg.getStudents();
    }


    public void saveCourse(Course course) {
        courseReg.saveCourse(course);
    }

    public void displayCourse(int id) {
        courseReg.display(id);
    }

    public void updateCourse(int id) {
        courseReg.updateCourse(id);
    }

    public void removeCourse(int id) {
        courseReg.removeCourse(id);
    }

    public void displayAllCourses() {
        courseReg.displayAll();
    }

    public double calculateTuitionFee(int units, double discountRate) {
        return tuitionFP.calculateTuitionFee(units, discountRate);
    }

    public void makePayment(double amount) {
        tuitionFP.makePayment(amount);
    }

    public double getRemainingBalance(int id) {
        return tuitionFP.getRemainingBalance(id);
    }

    public boolean isFullyPaid(int id) {
        return tuitionFP.isFullyPaid(id);
    }
}