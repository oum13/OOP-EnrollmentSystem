package org.example.service;

public interface TuitionFP {
    double calculateTuitionFee(int units, double discountRate);
    void makePayment(double amount);
    double getRemainingBalance(int id);
    boolean isFullyPaid(int id);
}
