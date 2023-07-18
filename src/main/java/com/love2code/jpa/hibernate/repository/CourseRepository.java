package com.love2code.jpa.hibernate.repository;

import com.love2code.jpa.hibernate.entity.Course;
import com.love2code.jpa.hibernate.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course foundCourse = findById(id);
         em.remove(foundCourse);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);
        Course course2 = new Course("Angular Js in 100 Steps");
        em.persist(course2);

        em.flush();

        course1.setName("Web Services in 100 Steps - Updated");
        course2.setName("Angular Js in 100 Steps - Updated");

        em.refresh(course1);
    }

    @Transactional
    public void addHardcodedReviewsForCourse(Long courseId, List<Review> reviews) {
        //get the course
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());

        for (Review review: reviews) {
            // add two reviews to it

            // setting the relationship
            course.addReview(review);
            review.setCourse(course);

            //save it to the database
            em.persist(review);
        }
    }

}
