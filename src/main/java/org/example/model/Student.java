package org.example.model;

public class Student extends Person {
    private String program;

    public Student(int ID, String name, String program){
        super(name, ID);
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void display(){
        System.out.println("Student ID: " + getID());
        System.out.println("Student Name: " + getName());
        System.out.println("Student Program: " + getProgram());
        System.out.println();
    }

    public void mainTask() {
        System.out.println("I study");
    }
}