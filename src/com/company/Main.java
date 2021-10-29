package com.company;

import com.company.Controller.Controller;
import com.company.Objects.Course;
import com.company.Objects.Student;
import com.company.Objects.Teacher;
import com.company.Repository.CourseRepo;
import com.company.Repository.StudentRepo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
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
        System.out.println((control.register(s1, c1)));
    }
}
