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

    public String updateEmployee(Employee employee, Long id) {
        Optional<Employee> employeeData = iEmployeeJpaRepository.findById(id);

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setFirstname(employee.getFirstname());
            _employee.setLastname(employee.getLastname());
            _employee.setEmployeeid(employee.getEmployeeid());
            _employee.setRole(employee.getRole());
            iEmployeeJpaRepository.save(_employee);
            return "El empleado ha sido actualizado";
        }else return "No se ha encontrado el empleado";
    }
}
