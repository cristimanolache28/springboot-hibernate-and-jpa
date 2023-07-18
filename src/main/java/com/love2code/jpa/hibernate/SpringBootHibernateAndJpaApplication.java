package com.love2code.jpa.hibernate;

import com.love2code.jpa.hibernate.entity.PartTimeEmployee;
import com.love2code.jpa.hibernate.repository.CourseRepository;
import com.love2code.jpa.hibernate.repository.EmployeeRepository;
import com.love2code.jpa.hibernate.repository.StudentRepository;
import com.love2code.jpa.hibernate.entity.FullTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringBootHibernateAndJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateAndJpaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
/*		employeeRepository.insert(
				new PartTimeEmployee("Jill", new BigDecimal("50")));

		employeeRepository.insert(
				new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("All employees -> {}", employeeRepository.retrieveAllEmployees());*/
	}
}
