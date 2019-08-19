package com.office.service;

import com.office.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee e);
    Employee getOne(long id);
    Employee getByName(String firstName);
    List<Employee> getAll();
    void delete(Employee e);

}
