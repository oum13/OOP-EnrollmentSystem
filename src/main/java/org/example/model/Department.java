package org.example.model;

import java.util.ArrayList;

public class Department {

    private int departmentID;
    private String departmentName;
    private ArrayList<Section> sections;

    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.sections = new ArrayList<>();
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
}
