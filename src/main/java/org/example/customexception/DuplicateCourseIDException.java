package org.example.customexception;

public class DuplicateCourseIDException extends Exception {
    public DuplicateCourseIDException(int id) {
        super("Registration failed: A course with ID " + id + " already exists.");
    }
}
