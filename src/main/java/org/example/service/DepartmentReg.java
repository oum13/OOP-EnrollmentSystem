package org.example.service;

import org.example.customexception.DepartmentNotFoundException;
import org.example.customexception.DuplicateDepartmentIDException;
import org.example.model.Department;
import org.example.model.Section;

import java.util.ArrayList;

public interface DepartmentReg {

    void saveDepartment(Department department) throws DuplicateDepartmentIDException;

    void addSectionToDepartment(int departmentID, Section section) throws DepartmentNotFoundException;

    void display(int departmentID);

    void displayAll();

    void removeDepartment(int departmentID);

    void viewHierarchy(int departmentID) throws DepartmentNotFoundException;

    ArrayList<Department> getDepartments();
}
