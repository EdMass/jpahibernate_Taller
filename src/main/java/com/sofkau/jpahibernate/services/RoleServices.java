package com.sofkau.jpahibernate.services;

import com.sofkau.jpahibernate.models.Role;
import com.sofkau.jpahibernate.repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleServices {
    @Autowired
    IRoleJpaRepository iRoleJpaRepository;

    public ArrayList<Role> getRoles(){
        return (ArrayList<Role>)iRoleJpaRepository.findAll();
    }

    public Role saveRole (Role role){
        return iRoleJpaRepository.save(role);
    }

    public Optional<Role> findbyRoleID(Long id){
        return iRoleJpaRepository.findById(id);
    }

    public boolean deleteRole(Long id) {
        try {
            iRoleJpaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public void updateRole(Role role){
         iRoleJpaRepository.save(role);
    }
}
