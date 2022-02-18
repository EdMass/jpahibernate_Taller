package com.sofkau.jpahibernate;

import com.sofkau.jpahibernate.models.Employee;
import com.sofkau.jpahibernate.repository.IEmployeeJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repo;

    @Test
    public void  saveEmployee(){
        Employee john = new Employee("John","Smith", "empl123");
        Employee claire = new Employee("Claire","Simpson", "empl124");

        repo.save(john);
        repo.save(claire);

        repo.flush();

        Assertions.assertEquals(2, repo.findAll().size());

    }
}
