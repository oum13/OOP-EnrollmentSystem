package org.example.service;

import java.util.Scanner;

public class IdChecker {
    Scanner scan = new Scanner(System.in);
    CourseRegistration courseRegistration;
    StudentRegistration studentRegistration;
    private int sc;
    private int id;
    private int identification;
    private boolean found = false;

    public IdChecker(StudentRegistration studentRegistration, CourseRegistration courseRegistration){
        this.courseRegistration = courseRegistration;
        this.studentRegistration = studentRegistration;
    }

    public void checkID(int n){
        if(n == 1){
            System.out.println("Student - 1 | Course - 2");
            sc = scan.nextInt();

            System.out.print("What id? ");
            identification = scan.nextInt();
        }else if(n == 2){
            sc = 1;
            System.out.print("What id? ");
            identification = scan.nextInt();
        }
        switch (sc){
            case 1:
                if(studentRegistration.getStudents().isEmpty()){
                    System.out.println("No students yet");
                    break;
                }

                for (int i = 0; i < studentRegistration.getStudents().size(); i++) {
                    if (studentRegistration.getStudents().get(i).getID() == identification) {
                        id = identification;
                        found = true;
                        break;
                    }
                }

                if(!found){
                    System.out.println("Student not found.");
                }
                break;
            case 2:
                if(courseRegistration.getCourses().isEmpty()){
                    System.out.println("No courses yet");
                    break;
                }

                for (int i = 0; i < courseRegistration.getCourses().size(); i++) {
                    if (courseRegistration.getCourses().get(i).getcourseID() == identification) {
                        id = identification;
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("Course not found.");
                }
                break;
            default:
                System.out.println("");
        }
    }

    public int getStOrC(){
        return sc;
    }

    public int getID(){
        return id;
    }
}
