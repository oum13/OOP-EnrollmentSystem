package org.example.customexception;

public class DuplicateSectionIDException extends Exception {
    public DuplicateSectionIDException(int id) {
        super("Registration failed: A section with ID " + id + " already exists.");
    }
}
