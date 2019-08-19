package com.office.repositories;

import com.office.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select e from Employee e where e.firstName=:firstName")
    public Employee findByName(@Param("firstName")String firstName);
}
