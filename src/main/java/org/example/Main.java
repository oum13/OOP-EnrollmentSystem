package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
import org.example.service.TuitionFeePayment;
import org.example.service.IdChecker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();
        TuitionFeePayment tuitionFeePayment = new TuitionFeePayment(studentRegistration);
        IdChecker idChecker = new IdChecker(studentRegistration, courseRegistration);

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
            System.out.println("7 - Exit");
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
                        studentRegistration.saveStudent(p);

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
                                case 1:
                                    discount = 0.50;
                                    break;
                                case 2:
                                    discount = 0.75;
                                    break;
                                case 3:
                                    discount = 1.00;
                                    break;
                                default:
                                    System.out.println("Oops");
                            }
                        }

                        System.out.printf("Your balance is: %.2f \n", tuitionFeePayment.calculateTuitionFee(units,discount));

                    } else if(sc == 2){
                        System.out.print("Name: ");
                        name = scan.nextLine();

                        System.out.print("ID: ");
                        id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Program: ");
                        program = scan.nextLine();

                        Course c = new Course(id, name, program);
                        courseRegistration.saveCourse(c);
                    }
                    break;
                case 2:
                    idChecker.checkID(1);

                    if(idChecker.getStOrC() == 1){
                        studentRegistration.display(idChecker.getID());
                    } else if(idChecker.getStOrC() == 2){
                        courseRegistration.display(idChecker.getID());
                    }
                    break;
                case 3:
                    idChecker.checkID(1);

                    if(idChecker.getStOrC() == 1){
                        studentRegistration.removeStudent(idChecker.getID());
                    } else if(idChecker.getStOrC() == 2){
                        courseRegistration.removeCourse(idChecker.getID());
                    }
                    break;
                case 4:
                    idChecker.checkID(1);

                    if(idChecker.getStOrC() == 1) {
                        studentRegistration.displayAll();
                    } else if(idChecker.getStOrC() == 2){
                        courseRegistration.displayAll();
                    }
                    break;
                case 5:
                    idChecker.checkID(1);

                    if(idChecker.getStOrC() == 1){
                        studentRegistration.updateStudent(idChecker.getID());
                    } else if(idChecker.getStOrC() == 2){
                        courseRegistration.updateCourse(idChecker.getID());
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
                        if(tuitionFeePayment.isFullyPaid(idChecker.getID())){
                            System.out.println("Tuition is fully paid.");
                            break;
                        }
                        System.out.printf("Remaining Balance: %.2f \n",
                                tuitionFeePayment.getRemainingBalance((idChecker.getID())));
                        System.out.print("How much will you pay? ");
                        double am = scan.nextDouble();
                        tuitionFeePayment.makePayment(am);
                    }else if(c == 2){
                        System.out.printf("Remaining Balance: %.2f \n",
                                tuitionFeePayment.getRemainingBalance((idChecker.getID())));
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}