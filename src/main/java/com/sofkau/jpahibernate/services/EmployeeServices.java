package com.sofkau.jpahibernate.services;

import com.sofkau.jpahibernate.models.Employee;
import com.sofkau.jpahibernate.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeServices {
    @Autowired
    IEmployeeJpaRepository iEmployeeJpaRepository;

    public ArrayList<Employee> getEmployee(){
        return (ArrayList<Employee>) iEmployeeJpaRepository.findAll();
    }

    public Employee saveEmployee (Employee employee){
        return iEmployeeJpaRepository.save(employee);
    }

    public Optional<Employee> findbyEmployeeID(Long id){
        return iEmployeeJpaRepository.findById(id);
    }

    public boolean deleteEmployee(Long id) {
        try {
            iEmployeeJpaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public void updateEmployee(Employee employee){
        iEmployeeJpaRepository.save(employee);
    }
}
