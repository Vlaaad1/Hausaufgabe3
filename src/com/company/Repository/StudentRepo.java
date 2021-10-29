package com.company.Repository;

import com.company.Objects.Student;

public class StudentRepo extends InMemoryRepo<Student> {
    public StudentRepo(){
        super();
    }
    /**
     * @param entity entity darf nicht null sein
     * @return null - Wenn das Entity aktualisiert wird,
     * gibt es sonst die Entity - (e.g id existiert nicht) zurück.
     */
    @Override
    public Student update(Student entity){
        for(Student s: repo_list) {
            if (s.equals(entity)){
                s.setStudentID(entity.getStudentID());
                s.setEnrolledCourses(entity.getEnrolledCourses());
                s.setTotalCredits(entity.getTotalCredits());
                return null;
            }
        }
        return entity;
    }
}
