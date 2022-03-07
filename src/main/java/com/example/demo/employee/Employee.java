package com.example.demo.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String pos;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Employee() {
    }

    public Employee(Long id, String name, String email, String pos, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pos = pos;
        this.dob = dob;
    }

    public Employee(String name, String email, String pos, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.pos = pos;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pos='" + pos + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
