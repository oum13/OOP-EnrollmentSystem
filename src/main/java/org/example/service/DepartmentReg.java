package org.example.service;

import org.example.model.Department;
import org.example.model.Section;

import java.util.ArrayList;

public interface DepartmentReg {

    void saveDepartment(Department department);

    void addSectionToDepartment(int departmentID, Section section);

    void display(int departmentID);

    void displayAll();

    void removeDepartment(int departmentID);

    void viewHierarchy(int departmentID);

    ArrayList<Department> getDepartments();
}
