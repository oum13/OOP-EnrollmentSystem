package org.example.model;

public class Course {
    private int courseID;
    private String courseName;
    private String program;

    public Course() {

    }

    public Course(int courseID, String courseName, String program){
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    public int getcourseID(){
        return courseID;
    }

    public String getcourseName(){
        return courseName;
    }

    public String getProgram(){
        return program;
    }

    public void setcourseID(int courseID){
        this.courseID = courseID;
    }

    public void setcourseName(String courseName){
        this.courseName = courseName;
    }

    public void setProgram(String program){
        this.program = program;
    }

}