package com.office.entities;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    private @Id @GeneratedValue
            @SequenceGenerator(name = "id_seq", initialValue = 1)
    long empId;
    private String firstName;
    private String lastName;
    private String role;

    public String getFirstName() {
        return firstName;
    }

    public long getEmpId() {
        return empId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee(String fName, String lName, String role){
        this.firstName=fName;
        this.lastName= lName;
        this.role=role;
    }
    public Employee(){

    }

}
