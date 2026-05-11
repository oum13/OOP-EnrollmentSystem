package org.example.service;

import org.example.customexception.InvalidPaymentAmountException;

import java.util.ArrayList;

public class TuitionFeePayment implements TuitionFP {
    ArrayList<Double> balances = new ArrayList<>();

    private double pricePerUnit = 1000.00;
    private int index;
    StudentReg studentRegistration;

    public TuitionFeePayment(StudentReg studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    @Override
    public double calculateTuitionFee(int units, double discountRate) {
        double totalTuition = (units * pricePerUnit);
        double discount = totalTuition * discountRate;
        double balance = totalTuition - discount;
        balances.add(balance);
        return balance;
    }

    @Override
    public void makePayment(double amount) throws InvalidPaymentAmountException {
        if (amount <= 0) {
            throw new InvalidPaymentAmountException(amount);
        }
        double remaining = balances.get(index);
        if (amount > remaining) {
            throw new InvalidPaymentAmountException(
                    "Payment failed: Amount " + amount
                            + " exceeds the remaining balance of " + remaining + ".");
        }
        double calculate = remaining - amount;
        balances.set(index, calculate);
        System.out.printf("Payment of %.2f accepted. Remaining balance: %.2f%n", amount, calculate);
    }

    @Override
    public double getRemainingBalance(int id) {
        double b = 0.00;
        for (int i = 0; i < studentRegistration.getStudents().size(); i++) {
            if (studentRegistration.getStudents().get(i).getID() == id) {
                b = balances.get(i);
            }
        }
        return b;
    }

    @Override
    public boolean isFullyPaid(int id) {
        double b = 0.00;
        for (int i = 0; i < studentRegistration.getStudents().size(); i++) {
            if (studentRegistration.getStudents().get(i).getID() == id) {
                b = balances.get(i);
                index = i;
            }
        }
        return b <= 0.0;
    }
}
