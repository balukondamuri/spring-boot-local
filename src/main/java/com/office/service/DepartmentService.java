package com.office.service;

import com.office.entities.Department;
import com.office.entities.Employee;

import java.util.List;

public interface DepartmentService {
    void addEmployeeToDepartment(Long deptId,Long empId);
    List<Department> getAllDepartments();
    Department add(Department d);
    Department getOne(Long id);
}
