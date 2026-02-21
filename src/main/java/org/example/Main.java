package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Student student = new Student();
//        student.setStudentID("000123");
//        student.setName("John Doe");
//        student.setProgram("Information Technology");
//
//        Student student2 = new Student();
//        student2.setStudentID("000124");
//        student2.setName("Jane Doe");
//        student2.setProgram("Information Technology");
//
//        Course course = new Course();
//        course.setCourseID("00001");
//        course.setCourseName("Integrative Programming");
//        course.setProgram("Information Technology");
//
//        student.display();
//        student2.display();
//        course.display();

        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();

        while(true){
            String name;
            int choice;
            int index;
            int id;
            int sc;

            System.out.println("1 - Add Student / Course");
            System.out.println("2 - Print ");
            System.out.println("3 - Remove");
            System.out.println("4 - Print All");
            System.out.println("5 - Update");
            System.out.print("What? ");
            choice = scan.nextInt();

            scan.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Student - 1 | Course - 2");
                    sc = scan.nextInt();

                    scan.nextLine();

                    if (sc == 1){
                        System.out.print("Name: ");
                        name = scan.nextLine();

                        System.out.print("ID: ");
                        id = scan.nextInt();

                        Student p = new Student(id, name);

                        studentRegistration.saveStudent(p);
                    }else if(sc == 2){
                        System.out.print("Name: ");
                        name = scan.nextLine();

                        System.out.print("ID: ");
                        id = scan.nextInt();

                        Course c = new Course(id, name);

                        courseRegistration.saveCourse(c);
                    }
                    break;
                case 2:
                    System.out.println("Student - 1 | Course - 2");
                    sc = scan.nextInt();

                    if(sc == 1){
                        System.out.print("What index? ");
                        index = scan.nextInt();
                        studentRegistration.display(index);
                    }else if(sc == 2){
                        System.out.print("What index? ");
                        index = scan.nextInt();
                        courseRegistration.display(index);
                    }
                    break;
                case 3:
                    System.out.println("Student - 1 | Course - 2");
                    sc = scan.nextInt();

                    if(sc == 1){
                        System.out.print("ID: ");
                        id = scan.nextInt();

                        studentRegistration.removeStudent(id);
                        System.out.println("Removed");
                    }else if(sc == 2){
                        System.out.print("ID: ");
                        id = scan.nextInt();

                        courseRegistration.removeCourse(id);
                        System.out.println("Removed");
                    }

                    break;
                case 4:
                    System.out.println("Student - 1 | Course - 2");
                    sc = scan.nextInt();

                    if(sc == 1) {
                        studentRegistration.displayAll();
                    }else if(sc == 2){
                        courseRegistration.displayAll();
                    }
                    break;
                case 5:
                    System.out.println("Student - 1 | Course - 2");
                    sc = scan.nextInt();

                    if(sc == 1){
                        System.out.print("What ID? ");
                        id = scan.nextInt();

                        studentRegistration.updateStudent(id);
                    }else if(sc == 2){
                        System.out.print("What ID? ");
                        id = scan.nextInt();

                        courseRegistration.updateCourse(id);
                    }

                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println();
            }
        }
    }
}