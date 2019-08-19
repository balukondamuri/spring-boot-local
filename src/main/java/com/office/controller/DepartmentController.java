package com.office.controller;

import com.office.entities.Department;
import com.office.entities.Employee;
import com.office.repositories.DepartmentRepository;
import com.office.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/all")
    List<Department> all(){
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{deptId}/{empId}")
    public void addDepartmentToEmp(@PathVariable Long deptId,@PathVariable Long empId){
        departmentService.addEmployeeToDepartment(deptId,empId);
    }

   @PostMapping("/add")
   ResponseEntity<Department> add(@RequestBody Department d) {
       departmentService.add(d);
       return ResponseEntity.noContent().build();
   }
}
