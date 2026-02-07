package org.example;

public class Student {
    private String studentID;
    private String studentName;
    private String program;

    public Student(){

    }

    public String getStudentID(){
        return studentID;
    }

    public String getStudentName(){
        return studentName;
    }

    public String getProgram(){
        return program;
    }

    public void setStudentID(String studentID){
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
