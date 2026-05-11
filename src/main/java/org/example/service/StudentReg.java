package org.example.service;

import org.example.customexception.DuplicateStudentIDException;
import org.example.model.Student;

import java.util.ArrayList;

public interface StudentReg {
    void saveStudent(Student student) throws DuplicateStudentIDException;
    void display(int id);
    void updateStudent(int id);
    void removeStudent(int id);
    void displayAll();
    ArrayList<Student> getStudents();
}
