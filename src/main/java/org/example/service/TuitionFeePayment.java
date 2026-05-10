package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class TuitionFeePayment {
    ArrayList<Double> balances = new ArrayList<>();

    private double pricePerUnit = 1000.00;
    private double balance;
    private double totalTuition;
    private int index;
    StudentRegistration studentRegistration;

    public TuitionFeePayment(StudentRegistration studentRegistration){
        this.studentRegistration = studentRegistration;
    }

    public double calculateTuitionFee(int units, double discountRate){
        totalTuition = (units * pricePerUnit);
        double discount = totalTuition * discountRate;
        balance = totalTuition - discount;
        balances.add(balance);
        return balance;
    }

    public void makePayment(double amount){
        double calculate = balances.get(index) - amount;
        balances.set(index, calculate);
    }

    public double getRemainingBalance(int id){
        double b = 0.00;
        for (int i = 0; i < studentRegistration.getStudents().size(); i++) {
            if (studentRegistration.getStudents().get(i).getID() == id) {
                b = balances.get(i);
            }
        }
        return b;
    }

    public boolean isFullyPaid(int id){
        double b = 0.00;
        for (int i = 0; i < studentRegistration.getStudents().size(); i++) {
            if (studentRegistration.getStudents().get(i).getID() == id) {
                b = balances.get(i);
                index = i;
            }
        }
        if(b == 0.00){
            return true;
        }else{
            return false;
        }
    }
}
