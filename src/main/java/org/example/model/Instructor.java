package org.example.model;

public class Instructor extends Person{

    private String Courses;

    public Instructor(String name, int ID){
        super(name, ID);
    }

    public void mainTask() {
        System.out.println("I teach");
    }

    public String getCourse() {
        return Courses;
    }

    public void setCourse(String course) {
        this.Courses = course;
    }
}
