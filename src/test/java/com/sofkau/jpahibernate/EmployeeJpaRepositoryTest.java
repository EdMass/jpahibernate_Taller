package com.sofkau.jpahibernate;

import com.sofkau.jpahibernate.models.Employee;
import com.sofkau.jpahibernate.models.Role;
import com.sofkau.jpahibernate.repository.IEmployeeJpaRepository;
import com.sofkau.jpahibernate.repository.IProjectJpaRepository;
import com.sofkau.jpahibernate.repository.IRoleJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repoEml;

    @Autowired
    private IRoleJpaRepository repoRole;

    @Autowired
    private IProjectJpaRepository repoProj;

    @Test
    public void  saveEmployee(){

        Role admin = new Role("ROLE_ADMIN");
        Role dev = new Role("ROLE_DEV");

        admin = repoRole.save(admin);
        dev = repoRole.save(dev);

        Project proj1 = new Project("proj1");
        Project proj2 = new Project("proj2");
        Project proj3 = new Project("proj3");

        proj1 = repoProj.save(proj1);
        proj2 = repoProj.save(proj2);
        proj3 = repoProj.save(proj3);

        Employee john = new Employee("John","Smith", "empl123",dev);
        Employee claire = new Employee("Claire","Simpson", "empl124", admin);

        john.getProjects().add(proj1);
        john.getProjects().add(proj2);

        claire.getProjects().add(proj1);
        claire.getProjects().add(proj2);
        claire.getProjects().add(proj3);

        repoEml.save(john);
        repoEml.save(claire);

        repoEml.flush();

        Employee emp124 = repoEml.findByEmployeeid("empl124");
        Assertions.assertEquals("Claire",emp124.getFirstname());
        Assertions.assertEquals(2, repoEml.findAll().size());
        Assertions.assertEquals(admin, emp124.getRole());
    }
}
