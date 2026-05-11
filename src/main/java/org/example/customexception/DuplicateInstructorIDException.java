package org.example.customexception;

public class DuplicateInstructorIDException extends Exception {
    public DuplicateInstructorIDException(int id) {
        super("Assignment failed: An instructor with ID " + id
                + " is already assigned to this section.");
    }
}
