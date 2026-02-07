package org.example;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.setStudentID("20202020");
        student.setName("Paul Geneo Ajeda");
        student.setProgram("BSIT");

        Course course = new Course();
        course.setCourseID("4004004040");
        course.setCourseName("Information Management");
        course.setProgram("BSIT");

        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student Program: " + student.getProgram());

        System.out.println("\nCourse ID: " + course.getCourseID());
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Course Program: " + course.getProgram());

    }
}