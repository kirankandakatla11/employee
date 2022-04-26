package com.kiranit.employee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@Setter
@Getter

public class EmployeeEntity {
    @Id
        private int empId;
    @Column
        private String firstName;
    @Column
        private String lastName;
    @Column
        private String salary;
    @Column
        private String address;
}
