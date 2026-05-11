package org.example.customexception;

public class DuplicateStudentIDException extends Exception {
    public DuplicateStudentIDException(int id) {
        super("Registration failed: A student with ID " + id + " already exists.");
    }
}
