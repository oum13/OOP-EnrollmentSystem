package org.example.service;

import org.example.customexception.DuplicateInstructorIDException;
import org.example.customexception.DuplicateSectionIDException;
import org.example.customexception.SectionFullException;
import org.example.customexception.SectionNotFoundException;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;

import java.util.ArrayList;

public class SectionRegistration implements SectionReg {

    private ArrayList<Section> sections = new ArrayList<>();

    @Override
    public void saveSection(Section section) throws DuplicateSectionIDException {
        for (Section s : sections) {
            if (s.getSectionID() == section.getSectionID()) {
                throw new DuplicateSectionIDException(section.getSectionID());
            }
        }
        sections.add(section);
        System.out.println("Section \"" + section.getSectionName() + "\" saved successfully.");
    }

    @Override
    public void display(int sectionID) {
        if (sections.isEmpty()) {
            System.out.println("No sections yet.");
            return;
        }
        for (Section section : sections) {
            if (section.getSectionID() == sectionID) {
                System.out.println("Section ID   : " + section.getSectionID());
                System.out.println("Section Name : " + section.getSectionName());
                System.out.println("Course       : " + (section.getCourse() != null ?
                                                        section.getCourse().getcourseName() : "N/A"));
                System.out.println("Instructor   : " + (section.getInstructor() != null ?
                                                        section.getInstructor().getName() : "Not assigned"));
                System.out.println("Enrollment   : " + section.getEnrolledStudents().size() + " / "
                                                     + Section.MAX_CAPACITY);
                System.out.println();
                return;
            }
        }
        System.out.println("Section with ID " + sectionID + " not found.");
    }

    @Override
    public void displayAll() {
        if (sections.isEmpty()) {
            System.out.println("No sections yet.");
            return;
        }
        for (Section section : sections) {
            System.out.println("Section ID   : " + section.getSectionID());
            System.out.println("Section Name : " + section.getSectionName());
            System.out.println("Course       : " + (section.getCourse() != null ? section.getCourse().getcourseName() : "N/A"));
            System.out.println("Instructor   : " + (section.getInstructor() != null ? section.getInstructor().getName() : "Not assigned"));
            System.out.println("Enrollment   : " + section.getEnrolledStudents().size() + " / " + Section.MAX_CAPACITY);
            System.out.println();
        }
    }

    @Override
    public void removeSection(int sectionID) {
        if (sections.isEmpty()) {
            System.out.println("No sections yet.");
            return;
        }
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionID() == sectionID) {
                sections.remove(i);
                System.out.println("Section with ID " + sectionID + " removed.");
                return;
            }
        }
        System.out.println("Section with ID " + sectionID + " not found.");
    }

    @Override
    public void assignInstructor(int sectionID, Instructor instructor)
            throws SectionNotFoundException, DuplicateInstructorIDException {
        for (Section section : sections) {
            if (section.getSectionID() == sectionID) {
                if (section.getInstructor() != null
                        && section.getInstructor().getID() == instructor.getID()) {
                    throw new DuplicateInstructorIDException(instructor.getID());
                }
                section.setInstructor(instructor);
                System.out.println("Instructor \"" + instructor.getName()
                        + "\" assigned to section \"" + section.getSectionName() + "\".");
                return;
            }
        }
        throw new SectionNotFoundException(sectionID);
    }

    @Override
    public boolean enrollStudentInSection(int sectionID, Student student)
            throws SectionNotFoundException, SectionFullException {
        for (Section section : sections) {
            if (section.getSectionID() == sectionID) {
                if (section.getEnrolledStudents().size() >= Section.MAX_CAPACITY) {
                    throw new SectionFullException(section.getSectionName(), Section.MAX_CAPACITY);
                }

                for (Student enrolledStudent : section.getEnrolledStudents()) {
                    if (enrolledStudent.getID() == student.getID()) {
                        System.out.println("Student \"" + student.getName()
                                + "\" is already enrolled in section \""
                                + section.getSectionName() + "\".");
                        return false;
                    }
                }

                section.getEnrolledStudents().add(student);
                System.out.println("Student \"" + student.getName()
                        + "\" enrolled in section \"" + section.getSectionName()
                        + "\". [" + section.getEnrolledStudents().size() + "/" + Section.MAX_CAPACITY + "]");
                return true;
            }
        }
        throw new SectionNotFoundException(sectionID);
    }

    @Override
    public ArrayList<Section> getSections() {
        return sections;
    }
}
