package com.love2code.jpa.hibernate;

import com.love2code.jpa.hibernate.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHibernateAndJpaApplication.class)
public class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void jpql_basic() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);

        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Type Query -> {}", resultList);
    }

    @Test
    public void all_courses_having_100Steps() {
        // "SELECT c FROM Course c WHERE name like '100% Steps' "

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. Define root for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. Define Predicates et using Criteria Builder
        Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");
        cq.where(like100Steps);
    }

    @Test
    public void all_courses_without_students() {
        // "Select c From Course c where c.students is empty"
        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));

        cq.where(studentsIsEmpty);
    }


}
