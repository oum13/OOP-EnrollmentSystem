package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.model.Instructor;
import org.example.service.StudentReg;
import org.example.service.StudentRegistration;
import org.example.service.SectionReg;
import org.example.service.SectionRegistration;
import org.example.service.CourseReg;
import org.example.service.CourseRegistration;
import org.example.service.TuitionFP;
import org.example.service.TuitionFeePayment;
import org.example.service.CampusRegistrar;
import org.example.service.IdChecker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentReg studentReg = new StudentRegistration();
        CourseReg courseReg = new CourseRegistration();
        SectionReg sectionReg = new SectionRegistration();
        TuitionFP tuitionFP = new TuitionFeePayment(studentReg);
        CampusRegistrar campusRegistrar = new CampusRegistrar(studentReg, courseReg, tuitionFP, sectionReg);
        IdChecker idChecker = new IdChecker(studentReg, courseReg, sectionReg);
        while(true){
            String name;
            String program;
            int choice;
            int id;
            int sc;

            System.out.println("1 - Register");
            System.out.println("2 - Print");
            System.out.println("3 - Remove");
            System.out.println("4 - Print All");
            System.out.println("5 - Update");
            System.out.println("6 - Tuition");
            System.out.println("7 - Stud or Ins");
            System.out.println("8 - Exit");
            System.out.print("What? ");
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Student - 1 | Course - 2");
                    sc = scan.nextInt();
                    scan.nextLine();

                    if (sc == 1){
                        double discount = 0.00;
                        System.out.print("Name: ");
                        name = scan.nextLine();

                        System.out.print("ID: ");
                        id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Program: ");
                        program = scan.nextLine();

                        Student p = new Student(id, name, program);
                        campusRegistrar.saveStudent(p);

                        System.out.print("How many units? ");
                        int units = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Scholarship (Yes / No)? ");
                        String dec = scan.nextLine().toLowerCase();

                        if(dec.equals("yes")){
                            System.out.println("1 - 50%");
                            System.out.println("2 - 75%");
                            System.out.println("3 - 100%");
                            System.out.print("How many percent? ");
                            int c = scan.nextInt();
                            switch(c){
                                case 1: discount = 0.50; break;
                                case 2: discount = 0.75; break;
                                case 3: discount = 1.00; break;
                                default: System.out.println("Oops");
                            }
                        }

                        System.out.printf("Your balance is: %.2f \n",
                                campusRegistrar.calculateTuitionFee(units, discount));

                    } else if(sc == 2){
                        System.out.print("Name: ");
                        name = scan.nextLine();

                        System.out.print("ID: ");
                        id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Program: ");
                        program = scan.nextLine();

                        Course c = new Course(id, name, program);
                        campusRegistrar.saveCourse(c);
                    }
                    break;

                case 2:
                    idChecker.checkID(1);
                    if(idChecker.getStOrC() == 1){
                        campusRegistrar.displayStudent(idChecker.getID());
                    } else if(idChecker.getStOrC() == 2){
                        campusRegistrar.displayCourse(idChecker.getID());
                    }
                    break;

                case 3:
                    idChecker.checkID(1);
                    if(idChecker.getStOrC() == 1){
                        campusRegistrar.removeStudent(idChecker.getID());
                    } else if(idChecker.getStOrC() == 2){
                        campusRegistrar.removeCourse(idChecker.getID());
                    }
                    break;

                case 4:
                    System.out.println("Student - 1 | Course - 2");
                    sc = scan.nextInt();
                    scan.nextLine();
                    if(sc == 1){
                        campusRegistrar.displayAllStudents();
                    } else if(sc == 2){
                        campusRegistrar.displayAllCourses();
                    }
                    break;

                case 5:
                    idChecker.checkID(1);
                    if(idChecker.getStOrC() == 1){
                        campusRegistrar.updateStudent(idChecker.getID());
                    } else if(idChecker.getStOrC() == 2){
                        campusRegistrar.updateCourse(idChecker.getID());
                    }
                    break;

                case 6:
                    int c;
                    try{
                        System.out.println("1 - Make Payment");
                        System.out.println("2 - Check Balance");
                        System.out.println("What do you want to do?");
                        c = scan.nextInt();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    idChecker.checkID(2);

                    if(c == 1){
                        if(campusRegistrar.isFullyPaid(idChecker.getID())){
                            System.out.println("Tuition is fully paid.");
                            break;
                        }
                        System.out.printf("Remaining Balance: %.2f \n",
                                campusRegistrar.getRemainingBalance(idChecker.getID()));
                        System.out.print("How much will you pay? ");
                        double am = scan.nextDouble();
                        campusRegistrar.makePayment(am);
                    } else if(c == 2){
                        System.out.printf("Remaining Balance: %.2f \n",
                                campusRegistrar.getRemainingBalance(idChecker.getID()));
                    }
                    break;

                case 7:
                    Student s = new Student(2020, "Nas", "IT");
                    Instructor i = new Instructor("ASD", 123);
                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}