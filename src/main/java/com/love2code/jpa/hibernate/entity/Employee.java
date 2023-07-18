package com.love2code.jpa.hibernate.entity;

import com.love2code.jpa.hibernate.repository.EmployeeRepository;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
