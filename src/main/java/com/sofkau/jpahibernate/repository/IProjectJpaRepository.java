package com.sofkau.jpahibernate.repository;

import com.sofkau.jpahibernate.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectJpaRepository extends JpaRepository<Project, Long> {
}
