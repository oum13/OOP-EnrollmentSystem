package org.example.model;

public class Student {
    private int studentID;
    private String studentName;
    private String program;

    public Student(){

    }

    public Student(int studentID, String studentName){
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public Integer getStudentID(){
        return studentID;
    }

    public String getStudentName(){
        return studentName;
    }

    public String getProgram(){
        return program;
    }

    public void setStudentID(Integer studentID){
        this.studentID = studentID;
    }

    public void setName(String studentName){
        this.studentName = studentName;
    }

    public void setProgram(String program){
        this.program = program;
    }

    public void display(){
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Student Program: " + getProgram());
        System.out.println();
    }
}
