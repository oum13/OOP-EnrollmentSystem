package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;

public interface StudentReg {
    void saveStudent(Student student);
    void display(int id);
    void updateStudent(int id);
    void removeStudent(int id);
    void displayAll();
    ArrayList<Student> getStudents();
}
