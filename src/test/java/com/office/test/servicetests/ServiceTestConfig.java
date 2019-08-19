package com.office.test.servicetests;

import com.office.repositories.EmployeeRepository;
import com.office.service.EmployeeService;
import com.office.service.impl.EmployeeServiceImpl;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceTestConfig {

    @Bean
    public EmployeeService employeeService(){
        return new EmployeeServiceImpl();
    }
}
