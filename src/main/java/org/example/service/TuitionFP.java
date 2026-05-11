package org.example.service;

import org.example.customexception.InvalidPaymentAmountException;

public interface TuitionFP {
    double calculateTuitionFee(int units, double discountRate);
    void makePayment(double amount) throws InvalidPaymentAmountException;
    double getRemainingBalance(int id);
    boolean isFullyPaid(int id);
}
