package com.love2code.jpa.hibernate.repository;

import com.love2code.jpa.hibernate.entity.Course;
import com.love2code.jpa.hibernate.entity.Passport;
import com.love2code.jpa.hibernate.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class StudentRepository {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student foundStudent = findById(id);
        em.remove(foundStudent);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void playWithEntityManager() {
        Student student1 = new Student("Web Services in 100 Steps");
        em.persist(student1);
        Student student2 = new Student("Angular Js in 100 Steps");
        em.persist(student2);

        em.flush();

        student1.setName("Web Services in 100 Steps - Updated");
        student2.setName("Angular Js in 100 Steps - Updated");

        em.refresh(student1);
    }
    
    public void saveStudentWithPassword() {
        Passport passport = new Passport("NDA0021");
        em.persist(passport);
        Student student = new Student("James");
        student.setPassport(passport);
        em.persist(student);
    }

    @Transactional
    public void insertStudentAndCourse(Student student, Course course) {
        em.persist(course);
        em.persist(student);

        course.addStudent(student);
        student.addCourse(course);

    }

}
