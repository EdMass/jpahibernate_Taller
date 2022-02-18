package com.sofkau.jpahibernate.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 25, nullable = false)
    private String fristname;

    @Column(length = 25, nullable = false)
    private String lastname;

    @Column(length = 25, nullable = false, unique = true)
    private String employeeid;

    public Employee() {
    }

    public Employee(String fristname, String lastname, String employeeid) {
        this.fristname = fristname;
        this.lastname = lastname;
        this.employeeid = employeeid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fristname='" + fristname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", employeeid='" + employeeid + '\'' +
                '}';
    }
}
