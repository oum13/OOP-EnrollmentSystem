package org.example.service;

import org.example.customexception.DuplicateInstructorIDException;
import org.example.customexception.DuplicateSectionIDException;
import org.example.customexception.SectionFullException;
import org.example.customexception.SectionNotFoundException;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;

import java.util.ArrayList;

public interface SectionReg {
    void saveSection(Section section) throws DuplicateSectionIDException;
    void display(int sectionID);
    void displayAll();
    void removeSection(int sectionID);
    void assignInstructor(int sectionID, Instructor instructor)
            throws SectionNotFoundException, DuplicateInstructorIDException;
    boolean enrollStudentInSection(int sectionID, Student student)
            throws SectionNotFoundException, SectionFullException;
    ArrayList<Section> getSections();
}
