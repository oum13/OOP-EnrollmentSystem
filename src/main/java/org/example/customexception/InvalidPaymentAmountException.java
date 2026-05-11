package org.example.customexception;

public class InvalidPaymentAmountException extends Exception {
    public InvalidPaymentAmountException(double amount) {
        super("Payment failed: Amount must be greater than zero. Received: " + amount);
    }

    public InvalidPaymentAmountException(String message) {
        super(message);
    }
}
