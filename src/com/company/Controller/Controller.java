package com.company.Controller;

import com.company.Objects.Course;
import com.company.Objects.Student;
import com.company.Repository.CourseRepo;
import com.company.Repository.StudentRepo;

import java.util.ArrayList;

/**
 * Classname Controller
 * Date: 29.10.2021
 */
public class Controller {
    private final StudentRepo sRepo;
    private final CourseRepo cRepo;

    /**
     * Class constructor.
     * @param sRepo ist ein Repository für Studenten
     * @param cRepo ist ein Repository für Kurse
     */
    public Controller(StudentRepo sRepo, CourseRepo cRepo) {
        this.sRepo = sRepo;
        this.cRepo = cRepo;
    }

    /**
     * @param stud is ein Student
     * @param course is ein Kurs
     * @return true, wenn der Student zum Kurs eingeschrieben ist
     */
    public boolean register(Student stud, Course course) {
        //erstens verifiziert man die Ausnahme
        if (course.getStudentsEnrolled().size() == course.getMaxEnrollment()) {
            System.out.println("Maximum number of students reached");
            return false;
        }
        else if (stud.getTotalCredits() + course.getCredit() > 30) {
            System.out.println("Maximum number of credits reached");
            return false;
        }
        else {
            ArrayList<Course> newCourseList = (ArrayList<Course>) stud.getEnrolledCourses();
            newCourseList.add(course);
            stud.setEnrolledCourses(newCourseList); //aktualisiert die Liste von Kursen
            stud.setTotalCredits(stud.getTotalCredits() + course.getCredit()); //aktualisiert die Anzahl von Credits
            ArrayList<Student> newStudList = (ArrayList<Student>) course.getStudentsEnrolled();
            newStudList.add(stud);
            course.setStudentsEnrolled(newStudList); //aktualisiert die Liste von Studenten
            return true;
        }
    }

    /**
     * @return der Kursliste mit verfügbaren Plätzen und Anzeige
     * die Kurse und die Anzahl der Plätze
     */
    public ArrayList<Course> retrieveCourses() {
        ArrayList<Course> newList = new ArrayList<>(); //erstellen eine neue Liste
        for (Course c : cRepo.findAll()) { //sucht man alle Kursen von cRepo
            if (c.getStudentsEnrolled().size() < c.getMaxEnrollment()) {
                newList.add(c);
                System.out.println(c + " " + (c.getMaxEnrollment() - c.getStudentsEnrolled().size()));
            }
        }
        return newList;
    }

    /**
     * @param course is a course
     * @return the list of students enrolled for course c
     */
    public ArrayList<Student> retrieveStudents(Course course) {
        return (ArrayList<Student>) cRepo.findOne(course).getStudentsEnrolled();
    }

    /**
     * @return alle Kurse
     */
    public ArrayList<Course> getAllCourses() {
        return (ArrayList<Course>) cRepo.findAll();
    }

    /**
     * Funktion updateCredits ändert die Anzahl der Kredite eines Kurses und es aktualisiert
     * auch die Gesamtkredite von die eingeschriebenen Studierenden
     *  @param c ist ein Kurs
     *  @param newCredits ist die neue Anzahl von Credits
     */
    public void updateCredits(Course c, int newCredits) {
        //hier kalkuliert man die Differenz zwischen den Wert von
        // alte Credits une newCredits
        int diff = c.getCredit() - newCredits;
        cRepo.findOne(c).setCredit(newCredits);
        for (Student s: c.getStudentsEnrolled()) {
            s.setTotalCredits(s.getTotalCredits() - diff);
            //hier aktualisiert man die Anzahl von Credits einen Student
            // der in den Kurs c angemeldet ist
        }
    }

    /**
     * Funktion deleteTeacher setzt den Lehrer für Kurs c auf null und
     * entfernt den Kurs von allen eingeschriebenen Schülern
     * @param c ist der Kurs, für den wir den Lehrer entfernen wollen
     */
    public void deleteTeacher (Course c) {
        c.getTeacher().getCourses().remove(c);//löscht man den Professor vom Kurs c
        c.setTeacher(null);
        for (Student s: c.getStudentsEnrolled()) {
            //entfernt den Kurs von allen eingeschriebenen Schülern
            ArrayList<Course> newCourseList = (ArrayList<Course>) s.getEnrolledCourses();
            newCourseList.remove(c);
            s.setEnrolledCourses(newCourseList);
        }
    }

}