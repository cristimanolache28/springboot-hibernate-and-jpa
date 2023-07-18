package com.love2code.jpa.hibernate.repository;

import com.love2code.jpa.hibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "course")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    // ----- Create costume query-----
    List<Course> findByName(String name);
    List<Course> countByName(String name);
    List<Course> findByNameAndId(String name, Long id);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);


}
