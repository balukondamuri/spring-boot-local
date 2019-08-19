package com.office.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Unable to find employee with Id " + id);
    }
    public EmployeeNotFoundException(String name){
        super("Unable to find employee with firstName " + name);
    }
}