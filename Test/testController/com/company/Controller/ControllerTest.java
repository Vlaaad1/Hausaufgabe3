package com.company.Controller;

import com.company.Objects.Course;
import com.company.Objects.Student;
import com.company.Objects.Teacher;
import com.company.Repository.CourseRepo;
import com.company.Repository.StudentRepo;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ControllerTest ist eine Klasse die überprüft,
 * dass alle Methoden der Klasse Controller gut funktioniert
 */
class ControllerTest {
    ControllerTest() {
    }

    @Test
    void register() {
        Student s1 = new Student("Catalin", "Radu", 12345, new ArrayList());
        Teacher t1 = new Teacher("Marian", "Iorga", new ArrayList());
        Course c1 = new Course("MAP", t1, 10, new ArrayList(), 12);
        Course c2 = new Course("BD", t1, 5, new ArrayList(), 30);
        StudentRepo sRepo = new StudentRepo();
        CourseRepo cRepo = new CourseRepo();
        Controller control = new Controller(sRepo, cRepo);
        sRepo.save(s1);
        cRepo.save(c1);
        cRepo.save(c2);
        Assertions.assertTrue(control.register(s1, c1));
        Assertions.assertFalse(control.register(s1, c2));
    }

    @Test
    void retrieveCourses() {
        Student s1 = new Student("Catalin", "Radu", 12345, new ArrayList());
        Teacher t1 = new Teacher("Marian", "Iorga", new ArrayList());
        Course c1 = new Course("MAP", t1, 10, new ArrayList(), 12);
        Course c2 = new Course("BD", t1, 5, new ArrayList(), 6);
        StudentRepo sRepo = new StudentRepo();
        CourseRepo cRepo = new CourseRepo();
        Controller control = new Controller(sRepo, cRepo);
        sRepo.save(s1);
        cRepo.save(c1);
        cRepo.save(c2);
        Assertions.assertEquals(((Course)control.retrieveCourses().get(0)).getName(), "MAP");
        Assertions.assertEquals(((Course)control.retrieveCourses().get(1)).getCredit(), 6);
    }

    @Test
    void retrieveStudents() {
        Student s1 = new Student("Robert", "Tudor", 12345, new ArrayList());
        Student s2 = new Student("Catalin", "Radu", 12346, new ArrayList());
        Student s3 = new Student("Marian", "Alexa", 12347, new ArrayList());
        Teacher t1 = new Teacher("Marian", "Iorga", new ArrayList());
        Course c1 = new Course("MAP", t1, 10, new ArrayList(), 12);
        Course c2 = new Course("BD", t1, 5, new ArrayList(), 6);
        StudentRepo sRepo = new StudentRepo();
        CourseRepo cRepo = new CourseRepo();
        Controller control = new Controller(sRepo, cRepo);
        sRepo.save(s1);
        cRepo.save(c1);
        cRepo.save(c2);
        control.register(s1, c1);
        control.register(s2, c1);
        control.register(s3, c1);
        control.register(s2, c2);
        Assertions.assertEquals(control.retrieveStudents(c1).size(), 3);
        Assertions.assertEquals(control.retrieveStudents(c2).size(), 1);
    }

    @Test
    void getAllCourses() {
        Student s1 = new Student("Robert", "Tudor", 12345, new ArrayList());
        Teacher t1 = new Teacher("Marian", "Iorga", new ArrayList());
        Teacher t2 = new Teacher("Maria", "Dana", new ArrayList());
        Course c1 = new Course("MAP", t1, 10, new ArrayList(), 12);
        Course c2 = new Course("BD", t1, 5, new ArrayList(), 6);
        Course c3 = new Course("LP", t1, 15, new ArrayList(), 10);
        Course c4 = new Course("WS", t2, 10, new ArrayList(), 4);
        Course c5 = new Course("ALG", t2, 10, new ArrayList(), 5);
        StudentRepo sRepo = new StudentRepo();
        CourseRepo cRepo = new CourseRepo();
        sRepo.save(s1);
        cRepo.save(c1);
        cRepo.save(c2);
        cRepo.save(c3);
        cRepo.save(c4);
        cRepo.save(c5);
        Controller control = new Controller(sRepo, cRepo);
        Assertions.assertEquals(control.getAllCourses().size(), 5);
        Assertions.assertEquals(((Course)control.getAllCourses().get(1)).getName(), "BD");
        Assertions.assertEquals(((Course)control.getAllCourses().get(4)).getName(), "ALG");
    }

    @Test
    void updateCredits() {
        Student s1 = new Student("Robert", "Tudor", 12345, new ArrayList());
        Student s2 = new Student("Catalin", "Radu", 12346, new ArrayList());
        Teacher t1 = new Teacher("Marian", "Iorga", new ArrayList());
        Teacher t2 = new Teacher("Maria", "Dana", new ArrayList());
        Course c1 = new Course("MAP", t1, 10, new ArrayList(), 12);
        Course c2 = new Course("BD", t1, 5, new ArrayList(), 6);
        StudentRepo sRepo = new StudentRepo();
        CourseRepo cRepo = new CourseRepo();
        sRepo.save(s1);
        sRepo.save(s2);
        cRepo.save(c1);
        cRepo.save(c2);
        Controller control = new Controller(sRepo, cRepo);
        control.register(s1, c1);
        control.register(s1, c2);
        control.updateCredits(c1, 6);
        Assertions.assertEquals(s1.getTotalCredits(), 12);
        control.updateCredits(c2, 8);
        control.register(s2, c1);
        control.register(s2, c2);
        Assertions.assertEquals(s1.getTotalCredits(), 14);

    }

    @Test
    void deleteTeacher() {
        Student s1 = new Student("Catalin", "Radu", 12345, new ArrayList());
        Teacher t1 = new Teacher("Marian", "Iorga", new ArrayList());
        Course c1 = new Course("MAP", t1, 10, new ArrayList(), 12);
        StudentRepo sRepo = new StudentRepo();
        CourseRepo cRepo = new CourseRepo();
        sRepo.save(s1);
        cRepo.save(c1);
        Controller control = new Controller(sRepo, cRepo);
        control.deleteTeacher(c1);
        Assertions.assertEquals(s1.getEnrolledCourses().size(), 0);
    }
}