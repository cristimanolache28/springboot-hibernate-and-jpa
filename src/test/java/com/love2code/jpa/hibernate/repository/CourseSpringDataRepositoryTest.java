package com.love2code.jpa.hibernate.repository;

import com.love2code.jpa.hibernate.SpringBootHibernateAndJpaApplication;
import com.love2code.jpa.hibernate.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHibernateAndJpaApplication.class)
public class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_course_present() {
        Optional<Course> course = repository.findById(10001L);
        assertTrue(course.isPresent());
    }

    @Test
    public void findById_course_not_present() {
        Optional<Course> course = repository.findById(1000L);
        assertFalse(course.isPresent());
    }

    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("First Page -> {} ", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        logger.info("Second Page -> {} ", secondPage.getContent());
    }

    @Test
    public void findUsingName() {
        logger.info("FindByName -> {}", repository.findByName("JPA in 50 Steps"));
    }





}
