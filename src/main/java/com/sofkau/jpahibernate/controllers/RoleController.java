package com.sofkau.jpahibernate.controllers;

import com.sofkau.jpahibernate.models.Role;
import com.sofkau.jpahibernate.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleServices roleServices;

    @GetMapping()
    public ArrayList<Role> getRole(){
        return roleServices.getRoles();
    }

    @PostMapping()
    public Role saveRole (@RequestBody Role role){
        return this.roleServices.saveRole(role);
    }

    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable("id") Long id){
        return this.roleServices.findbyRoleID(id);
    }

    @PutMapping("/{id}")
    public String updateRole(@PathVariable("id") long id, @RequestBody Role role){
        return roleServices.updateRole(role, id);
    }

    @DeleteMapping("/{id}")
    public String deleteRoleById(@PathVariable("id") Long id){
        boolean ok = this.roleServices.deleteRole(id);
        if (ok){
            return  "se elliminó el Role con id "+ id;
        }else{
            return "No se pudo eliminar el Role con id "+id;
        }
    }
}
