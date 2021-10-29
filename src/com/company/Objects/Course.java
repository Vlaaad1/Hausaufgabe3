package com.company.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Date: 29.10.2021
 */
public class Course {
    private String name;
    private Teacher teacher;
    private int maxEnrollment;
    List<Student> studentsEnrolled;
    private int credit;

    /**
     * Konstruktor der Klasse
     * @param name Name des Kurses
     * @param teacher Name des Professors
     * @param maxEnrollment maximale Anzahl von Studenten
     * @param studentsEnrolled Liste von Studenten
     * @param credit Anzahl von Kredits, die der Kurse hat
     */
    public Course(String name, Teacher teacher, int maxEnrollment, List<Student> studentsEnrolled, int credit) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credit = credit;
        ArrayList<Course> courseList = (ArrayList<Course>) teacher.getCourses();
        courseList.add(this);
        teacher.setCourses(courseList);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public int getMaxEnrollment() { return maxEnrollment; }
    public void setMaxEnrollment(int maxEnrollment) { this.maxEnrollment = maxEnrollment; }

    public List<Student> getStudentsEnrolled() { return studentsEnrolled; }
    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }

    /**
     * @return String mit dem Namen des Kurses, maximalen Anzahl der Studenten und Anzahl des Kredits
     */
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", maxEnrollment=" + maxEnrollment +
                ", credit=" + credit +
                '}';
    }

    /**
     * @param o Objekt das verglichen werden soll
     * @return boolean Wert durch Vergleich der Namen zweier Kurse
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
