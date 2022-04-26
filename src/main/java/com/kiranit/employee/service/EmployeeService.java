package com.kiranit.employee.service;

import com.kiranit.employee.domain.Employee;
import com.kiranit.employee.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public String saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeId(Integer empId);
}


