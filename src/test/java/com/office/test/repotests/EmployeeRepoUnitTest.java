package com.office.test.repotests;

import com.office.entities.Employee;
import com.office.repositories.EmployeeRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepoUnitTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void addEmployeeTest(){
        Employee e = new Employee("TestFirstName","TestLastName","Engineer");
        testEntityManager.persist(e);
        testEntityManager.flush();

        Employee found = employeeRepository.findByName(e.getFirstName());
        assertThat(found.getFirstName()).isEqualTo(e.getFirstName());
    }

}
