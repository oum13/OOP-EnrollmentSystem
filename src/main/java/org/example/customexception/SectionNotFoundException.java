package org.example.customexception;

public class SectionNotFoundException extends Exception {
    public SectionNotFoundException(int id) {
        super("Section with ID " + id + " was not found.");
    }
}
