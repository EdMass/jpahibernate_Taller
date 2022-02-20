package com.sofkau.jpahibernate.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 25, nullable = false)
    private String firstname;

    @Column(length = 25, nullable = false)
    private String lastname;

    @Column(length = 10, nullable = false, unique = true)
    private String employeeid;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<Project> projects = new ArrayList<Project>();

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Role getRole() {
        return role;
    }

    public Employee() {
    }

    public Employee(String fristname, String lastname, String employeeid, Role role) {
        this.firstname = fristname;
        this.lastname = lastname;
        this.employeeid = employeeid;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public void setRole(Role role) {
        this.role = role;
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
                ", fristname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", role="+role.getName()+'}';
    }
}
