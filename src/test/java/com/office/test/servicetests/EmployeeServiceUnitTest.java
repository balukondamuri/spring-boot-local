package com.office.test.servicetests;

import com.office.entities.Employee;
import com.office.exception.EmployeeNotFoundException;
import com.office.repositories.EmployeeRepository;
import com.office.service.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
public class EmployeeServiceUnitTest {

    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){
        Employee e= new Employee("Emp1","ELast","Sr Engineer");
        Employee e2= new Employee("Emp2","Elast2","Sr Engineer-Test");
        Mockito.when(employeeRepository.findByName(e.getFirstName())).thenReturn(e);
        Mockito.when(employeeRepository.findByName(e2.getFirstName())).thenReturn(e2);
    }

    @Test
    public void testFindEmployeeByName(){
        String[] names={"Emp1","Emp2"};
        for(String name: names){
            Employee found= employeeService.getByName(name);
            assertThat(found.getFirstName()).isEqualTo(name);
        }
    }

    @Test
    public void testFindEmployeeById(){
        String[] names={"Emp1","Emp2"};
        for(String name: names){
            Employee found= employeeService.getByName(name);
            assertThat(found.getEmpId()).isNotNull();
        }
    }

    @Test
    public void testAddEmployee(){
        Employee e = new Employee("TestE","TestLastName","Engineer");
        assertThat(employeeService.add(e)).isEqualTo(e);

    }

    @Test
    public void testAddingEmptyEmployee(){
        Employee e  = new Employee();
        assertThat(employeeService.add(e)).isEqualTo(null);

    }

    @Test(expected = EmployeeNotFoundException.class)
    public void testFindInvalidEmployee(){
        String name="NoEmp";
        employeeService.getByName(name);
    }

}
