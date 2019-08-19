package com.office.service.impl;

import com.office.entities.Department;
import com.office.entities.Employee;
import com.office.repositories.DepartmentRepository;
import com.office.repositories.EmployeeRepository;
import com.office.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void addEmployeeToDepartment(Long deptId,Long empId) {
        Department d=  departmentRepository.findById(deptId).get();
        Employee e = employeeRepository.findById(empId).get();
        d.setEmployee(e);
        departmentRepository.save(d);

    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department add(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Department getOne(Long id) {
        return departmentRepository.findById(id).get();
    }


}