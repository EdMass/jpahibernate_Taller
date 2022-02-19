package com.sofkau.jpahibernate.controllers;

import com.sofkau.jpahibernate.models.Employee;
import com.sofkau.jpahibernate.services.EmployeeServices;
import com.sofkau.jpahibernate.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServices employeeServices;
    RoleServices roleServices;

    @GetMapping()
    public ArrayList<Employee> getEmployee(){
        return employeeServices.getEmployee();
    }

    @PostMapping("/add")
    public Employee saveEmployee (@RequestBody Employee employee){
        return this.employeeServices.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id){
        return this.employeeServices.findbyEmployeeID(id);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return employeeServices.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        boolean ok = this.employeeServices.deleteEmployee(id);
        if (ok){
            return  "se elliminó el Role con id "+ id;
        }else{
            return "No se pudo eliminar el Role con id "+id;
        }
    }
}
