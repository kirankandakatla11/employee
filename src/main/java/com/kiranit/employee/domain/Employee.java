package com.kiranit.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String salary;
    private String address;
    private Department department;

}