package com.company.Objects;

import java.util.List;

/**
 * Klasse Student ist eine Unterklasse der Klasse Person
 * firstName, lastName sind die Attribute geerbt von Person
 * Student hat auch studentID, enrolledCourses als Attribute
 * Date: 29.10.2021
 */
public class Student extends Person{
    private long  studentID;
    private int totalCredits;
    private List<Course> enrolledCourses;

    /**
     * Konstruktor der Klasse
     * @param firstName Vorname des Studentes
     * @param lastName Nachname des Studentes
     * @param studentID ID des Students
     * @param enrolledCourses Liste von Kursen
     */
    public Student(String firstName, String lastName, long studentID, List<Course> enrolledCourses) {
        super(firstName, lastName);
        this.studentID = studentID;
        this.enrolledCourses = enrolledCourses;
        for (Course course:this.enrolledCourses)
            totalCredits += course.getCredit();
    }
    public long getStudentID() { return studentID; }
    public void setStudentID(long studentID) { this.studentID = studentID; }

    public int getTotalCredits() { return totalCredits; }
    public void setTotalCredits(int totalCredits) { this.totalCredits = totalCredits; }

    public List<Course> getEnrolledCourses() { return enrolledCourses; }
    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

}
