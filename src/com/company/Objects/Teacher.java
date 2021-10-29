package com.company.Objects;

import java.util.List;

/**
 * Date: 29.10.2021
 */
public class Teacher extends Person {
    private List<Course> courses;

    /**
     * Konstruktor der Klasse
     * @param firstName Vorname des Professors
     * @param lastName Nachname des Professors
     * @param courses Liste von Kursen
     */
    public Teacher(String firstName, String lastName, List<Course> courses) {
        super(firstName,lastName);
        this.courses = courses;
    }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
