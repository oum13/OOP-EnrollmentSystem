package org.example.customexception;

public class SectionFullException extends Exception {
    public SectionFullException(String sectionName, int capacity) {
        super("Enrollment failed: Section \"" + sectionName
                + "\" is already at full capacity (" + capacity + " students).");
    }
}
