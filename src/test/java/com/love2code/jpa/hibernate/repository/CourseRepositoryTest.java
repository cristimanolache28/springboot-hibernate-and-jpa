package com.love2code.jpa.hibernate.repository;

import com.love2code.jpa.hibernate.SpringBootHibernateAndJpaApplication;
import com.love2code.jpa.hibernate.entity.Course;
import com.love2code.jpa.hibernate.entity.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHibernateAndJpaApplication.class)
@Transactional
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager  entityManager;
    
    @Test
    public void contextLoads() {
        logger.info("The test is running.");
    };

    @Test
    public void findCourseByIdTest() {
        Course courseFound = repository.findById(10001L);
        assertEquals("JPA Full Course", courseFound.getName());
    }

    @Test
    @DirtiesContext
    public void deleteCourseById() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    public void createCourse() {
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());

        course.setName("JPA in 50 Steps - Updated");
        repository.save(course);

        Course updatedCourse = repository.findById(10001L);
        assertEquals("JPA in 50 Steps - Updated", course.getName());

    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        repository.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(10002L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = entityManager.find(Review.class, 50001L);
        logger.info("{}", review.getCourse());
    }

}
