package com.office.controller;


import com.office.entities.Employee;
import com.office.exception.EmployeeNotFoundException;
import com.office.repositories.EmployeeRepository;
import com.office.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    List<Employee> all(){
       return employeeService.getAll();
    }

    @PostMapping("/add")
    Employee addEmployee(@RequestBody Employee e){
       return employeeService.add(e);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id){
       Employee e= employeeService.getOne(id);
       employeeService.delete(e);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    Resource<Employee> one(@PathVariable Long id){
        Employee employee = employeeService.getOne(id);

     return new Resource<>(employee,
             linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
             linkTo(methodOn(EmployeeController.class).all()).withRel("employees")
     );
    }

    @GetMapping("/firstName/{firstName}")
    Employee getByName(@PathVariable String firstName){
        return employeeService.getByName(firstName);
    }

}
