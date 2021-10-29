package com.company.Repository;

import com.company.Objects.Course;

public class CourseRepo extends InMemoryRepo<Course>{
    public CourseRepo(){
        super();
    }
    /**
     * @param entity entity darf nicht null sein
     * @return null - Wenn das Entity aktualisiert wird,
     * gibt es sonst die Entity - (e.g id existiert nicht) zurück.
     */
    @Override
    public Course update(Course entity) {
        for(Course c:repo_list) {
            if (c.equals(entity)){
                c.setCredit(entity.getCredit());
                c.setMaxEnrollment(entity.getMaxEnrollment());
                c.setTeacher(entity.getTeacher());
                c.setStudentsEnrolled(entity.getStudentsEnrolled());
                return null;
            }
        }
        return entity;
    }
}
