package com.love2code.jpa.hibernate.repository;

import com.love2code.jpa.hibernate.SpringBootHibernateAndJpaApplication;
import com.love2code.jpa.hibernate.entity.Course;
import com.love2code.jpa.hibernate.entity.Passport;
import com.love2code.jpa.hibernate.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHibernateAndJpaApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void someTest() {
        Student student = entityManager.find(Student.class, 20003L);
        Passport passport = student.getPassport();
        passport.setNumber("E123457");
        student.setName("Kim - updated name");
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrieveStudentAndAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 40001L);
        logger.info("Passport -> {}", passport);
        logger.info("Associated Student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourse() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("Student: { }", student);
        logger.info("Student Courses: -> { }", student.getCourses());
    }


}
