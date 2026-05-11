package org.example.model;

import java.util.ArrayList;

public class Section {
    private int sectionID;
    private String sectionName;
    private Course course;
    private Instructor instructor;
    private ArrayList<Student> enrolledStudents;

    public static final int MAX_CAPACITY = 30;

    public Section(int sectionID, String sectionName, Course course) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.course = course;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getSectionID() {
        return sectionID;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }


    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
