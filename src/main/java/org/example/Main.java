package org.example;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.setStudentID("000123");
        student.setName("John Doe");
        student.setProgram("Information Technology");

        Student student2 = new Student();
        student2.setStudentID("000124");
        student2.setName("Jane Doe");
        student2.setProgram("Information Technology");

        Course course = new Course();
        course.setCourseID("00001");
        course.setCourseName("Integrative Programming");
        course.setProgram("Information Technology");

        student.display();
        student2.display();
        course.display();

    }
}