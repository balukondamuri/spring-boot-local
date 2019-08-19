package com.office.service.impl;

import com.office.entities.Employee;
import com.office.exception.EmployeeNotFoundException;
import com.office.repositories.EmployeeRepository;
import com.office.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee add(Employee e) {
        if(e.getFirstName()==null){
            return null;
        }else {
            employeeRepository.save(e);
            return e;
        }
    }

    @Override
    public Employee getOne(long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));

    }

    @Override
    public Employee getByName(String firstName) {

            Employee e= employeeRepository.findByName(firstName);
            if(e==null){
                System.out.println(e);
                throw  new EmployeeNotFoundException(firstName);
            }else{
                return e;
            }
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Employee e) {
        employeeRepository.delete(e);
    }
}
