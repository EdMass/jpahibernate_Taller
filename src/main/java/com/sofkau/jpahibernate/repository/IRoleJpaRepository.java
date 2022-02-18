package com.sofkau.jpahibernate.repository;

import com.sofkau.jpahibernate.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleJpaRepository extends JpaRepository<Role, Long> {
}
