package com.office.data;


import com.office.entities.Department;
import com.office.entities.Employee;
import com.office.repositories.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.office.repositories.EmployeeRepository;


@Configuration
@Slf4j
public class LoadData {

    Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDb(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository){
        return args->{
            log.info("Preloading Employee " + employeeRepository.save(new Employee("James","Helms","Engineer")));
            log.info("Preloading Employee" + employeeRepository.save(new Employee("Jacob", "Hens","Senior Engineer")));
            log.info("Preloading Department"+ departmentRepository.save(new Department(100,"Information Technology")));
        };
    }
}
