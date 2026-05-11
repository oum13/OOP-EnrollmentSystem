package org.example.service;

import org.example.customexception.DepartmentNotFoundException;
import org.example.customexception.DuplicateDepartmentIDException;
import org.example.model.Department;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;

import java.util.ArrayList;

public class DepartmentRegistration implements DepartmentReg {

    private ArrayList<Department> departments = new ArrayList<>();

    @Override
    public void saveDepartment(Department department) throws DuplicateDepartmentIDException {
        for (Department d : departments) {
            if (d.getDepartmentID() == department.getDepartmentID()) {
                throw new DuplicateDepartmentIDException(department.getDepartmentID());
            }
        }
        departments.add(department);
        System.out.println("Department \"" + department.getDepartmentName() + "\" saved successfully.");
    }

    @Override
    public void addSectionToDepartment(int departmentID, Section section) throws DepartmentNotFoundException {
        for (Department department : departments) {
            if (department.getDepartmentID() == departmentID) {
                department.getSections().add(section);
                System.out.println("Section \"" + section.getSectionName()
                        + "\" added to department \"" + department.getDepartmentName() + "\".");
                return;
            }
        }
        throw new DepartmentNotFoundException(departmentID);
    }

    @Override
    public void display(int departmentID) {
        if (departments.isEmpty()) {
            System.out.println("No departments registered yet.");
            return;
        }
        for (Department department : departments) {
            if (department.getDepartmentID() == departmentID) {
                System.out.println("Department ID   : " + department.getDepartmentID());
                System.out.println("Department Name : " + department.getDepartmentName());
                System.out.println("Sections        : " + department.getSections().size());
                return;
            }
        }
        System.out.println("Department with ID " + departmentID + " not found.");
    }

    @Override
    public void displayAll() {
        if (departments.isEmpty()) {
            System.out.println("No departments registered yet.");
            return;
        }
        System.out.println("===== All Departments =====");
        for (Department department : departments) {
            System.out.println("  ID   : " + department.getDepartmentID());
            System.out.println("  Name : " + department.getDepartmentName());
            System.out.println("  Sections: " + department.getSections().size());
            System.out.println();
        }
    }

    @Override
    public void removeDepartment(int departmentID) {
        if (departments.isEmpty()) {
            System.out.println("No departments registered yet.");
            return;
        }
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartmentID() == departmentID) {
                String name = departments.get(i).getDepartmentName();
                departments.remove(i);
                System.out.println("Department \"" + name + "\" removed successfully.");
                return;
            }
        }
        System.out.println("Department with ID " + departmentID + " not found.");
    }

    @Override
    public void viewHierarchy(int departmentID) throws DepartmentNotFoundException {
        for (Department department : departments) {
            if (department.getDepartmentID() == departmentID) {
                System.out.println("==============================================");
                System.out.println(" DEPARTMENT : " + department.getDepartmentName()
                        + "  (ID: " + department.getDepartmentID() + ")");
                System.out.println("==============================================");

                ArrayList<Section> sections = department.getSections();

                if (sections.isEmpty()) {
                    System.out.println("  (No sections assigned to this department)");
                    return;
                }

                for (int s = 0; s < sections.size(); s++) {
                    Section section = sections.get(s);
                    boolean isLastSection = (s == sections.size() - 1);
                    String sectionBranch = isLastSection ? "└─" : "├─";

                    System.out.println();
                    System.out.println("  " + sectionBranch + " SECTION : " + section.getSectionName()
                            + "  (ID: " + section.getSectionID() + ")");

                    Instructor instructor = section.getInstructor();
                    String instructorLine = (instructor != null)
                            ? instructor.getName() + "  (ID: " + instructor.getID() + ")"
                            : "Not assigned";
                    System.out.println("  │    ├─ Instructor : " + instructorLine);

                    ArrayList<Student> students = section.getEnrolledStudents();
                    System.out.println("  │    └─ Enrolled Students ["
                            + students.size() + "/" + Section.MAX_CAPACITY + "] :");

                    if (students.isEmpty()) {
                        System.out.println("  │         (No students enrolled)");
                    } else {
                        for (int st = 0; st < students.size(); st++) {
                            Student student = students.get(st);
                            boolean isLastStudent = (st == students.size() - 1);
                            String studentBranch = isLastStudent ? "└─" : "├─";
                            System.out.println("  │         " + studentBranch + " "
                                    + student.getName()
                                    + "  (ID: " + student.getID()
                                    + " | Program: " + student.getProgram() + ")");
                        }
                    }
                }

                System.out.println();
                System.out.println("==============================================");
                return;
            }
        }
        throw new DepartmentNotFoundException(departmentID);
    }

    @Override
    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
