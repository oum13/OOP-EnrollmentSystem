package org.example.service;

import org.example.customexception.DepartmentNotFoundException;
import org.example.customexception.DuplicateCourseIDException;
import org.example.customexception.DuplicateDepartmentIDException;
import org.example.customexception.DuplicateInstructorIDException;
import org.example.customexception.DuplicateSectionIDException;
import org.example.customexception.DuplicateStudentIDException;
import org.example.customexception.InvalidPaymentAmountException;
import org.example.customexception.SectionFullException;
import org.example.customexception.SectionNotFoundException;
import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;

import java.util.ArrayList;

public class CampusRegistrar {
    private StudentReg studentReg;
    private CourseReg courseReg;
    private TuitionFP tuitionFP;
    private SectionReg sectionReg;
    private DepartmentReg departmentReg;

    public CampusRegistrar(StudentReg studentReg, CourseReg courseReg, TuitionFP tuitionFP,
                           SectionReg sectionReg, DepartmentReg departmentReg) {
        this.studentReg = studentReg;
        this.courseReg = courseReg;
        this.tuitionFP = tuitionFP;
        this.sectionReg = sectionReg;
        this.departmentReg = departmentReg;
    }

    public void saveStudent(Student student) throws DuplicateStudentIDException {
        studentReg.saveStudent(student);
    }

    public void displayStudent(int id) {
        studentReg.display(id);
    }

    public void updateStudent(int id) {
        studentReg.updateStudent(id);
    }

    public void removeStudent(int id) {
        studentReg.removeStudent(id);
    }

    public void displayAllStudents() {
        studentReg.displayAll();
    }

    public ArrayList<Student> getStudents() {
        return studentReg.getStudents();
    }

    public void saveCourse(Course course) throws DuplicateCourseIDException {
        courseReg.saveCourse(course);
    }

    public void displayCourse(int id) {
        courseReg.display(id);
    }

    public void updateCourse(int id) {
        courseReg.updateCourse(id);
    }

    public void removeCourse(int id) {
        courseReg.removeCourse(id);
    }

    public void displayAllCourses() {
        courseReg.displayAll();
    }

    public ArrayList<Course> getCourses() {
        return courseReg.getCourses();
    }

    public double calculateTuitionFee(int units, double discountRate) {
        return tuitionFP.calculateTuitionFee(units, discountRate);
    }

    public void makePayment(double amount) throws InvalidPaymentAmountException {
        tuitionFP.makePayment(amount);
    }

    public double getRemainingBalance(int id) {
        return tuitionFP.getRemainingBalance(id);
    }

    public boolean isFullyPaid(int id) {
        return tuitionFP.isFullyPaid(id);
    }

    public void saveSection(Section section) throws DuplicateSectionIDException {
        sectionReg.saveSection(section);
    }

    public void displaySection(int sectionID) {
        sectionReg.display(sectionID);
    }

    public void displayAllSections() {
        sectionReg.displayAll();
    }

    public void removeSection(int sectionID) {
        sectionReg.removeSection(sectionID);
    }

    public void assignInstructor(int sectionID, Instructor instructor)
            throws SectionNotFoundException, DuplicateInstructorIDException {
        sectionReg.assignInstructor(sectionID, instructor);
    }

    public boolean enrollStudentInSection(int sectionID, Student student)
            throws SectionNotFoundException, SectionFullException {
        return sectionReg.enrollStudentInSection(sectionID, student);
    }

    public ArrayList<Section> getSections() {
        return sectionReg.getSections();
    }

    // ── Department ──────────────────────────────────────────────────────────

    public void saveDepartment(Department department) throws DuplicateDepartmentIDException {
        departmentReg.saveDepartment(department);
    }

    public void addSectionToDepartment(int departmentID, Section section) throws DepartmentNotFoundException {
        departmentReg.addSectionToDepartment(departmentID, section);
    }

    public void displayDepartment(int departmentID) {
        departmentReg.display(departmentID);
    }

    public void displayAllDepartments() {
        departmentReg.displayAll();
    }

    public void removeDepartment(int departmentID) {
        departmentReg.removeDepartment(departmentID);
    }

    public void viewDepartmentHierarchy(int departmentID) throws DepartmentNotFoundException {
        departmentReg.viewHierarchy(departmentID);
    }

    public ArrayList<Department> getDepartments() {
        return departmentReg.getDepartments();
    }
}