package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;

import java.util.ArrayList;

public interface SectionReg {
    void saveSection(Section section);
    void display(int sectionID);
    void displayAll();
    void removeSection(int sectionID);
    void assignInstructor(int sectionID, Instructor instructor);
    boolean enrollStudentInSection(int sectionID, Student student);
    ArrayList<Section> getSections();
}
