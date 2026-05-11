package org.example.customexception;

public class DepartmentNotFoundException extends Exception {
    public DepartmentNotFoundException(int id) {
        super("Department with ID " + id + " was not found.");
    }
}
