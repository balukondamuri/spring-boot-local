package com.office.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Department {
    private @Id long departmentId;
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @ManyToOne
    @JoinColumn(name="empId")
    public
    Employee employee;

    public Department(long id, String departmentName){
        this.departmentId=id;
        this.departmentName=departmentName;
    }
   public Department(){

    }

    public void setEmployee(Employee e){
        this.employee=e;
    }
}
