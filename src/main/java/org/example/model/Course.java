package org.example.model;

public class Course {
    private int courseID;
    private String courseName;
    private String program;

    public Course(){

    }

    public Course(int courseID, String courseName){
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public Integer getcourseID(){
        return courseID;
    }

    public String getcourseName(){
        return courseName;
    }

    public String getProgram(){
        return program;
    }

    public void setcourseID(Integer courseID){
        this.courseID = courseID;
    }

    public void setcourseName(String courseName){
        this.courseName = courseName;
    }

    public void setProgram(String program){
        this.program = program;
    }

    public void display(){
        System.out.println("Student ID: " + getcourseID());
        System.out.println("Student Name: " + getcourseName());
        System.out.println("Student ID: " + getProgram());
        System.out.println();
    }
}
