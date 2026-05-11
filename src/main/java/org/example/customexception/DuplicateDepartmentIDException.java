package org.example.customexception;

public class DuplicateDepartmentIDException extends Exception {
    public DuplicateDepartmentIDException(int id) {
        super("Registration failed: A department with ID " + id + " already exists.");
    }
}
