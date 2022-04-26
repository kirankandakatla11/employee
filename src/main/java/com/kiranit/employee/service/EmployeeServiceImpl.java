package com.kiranit.employee.service;

import com.kiranit.employee.dao.EmployeeDao;
import com.kiranit.employee.domain.Employee;
import com.kiranit.employee.entity.EmployeeEntity;
import com.kiranit.employee.exception.RestTemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    RestTemplate restTemplate;

    public String saveEmployee(Employee employee){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        employeeEntity.setEmpId(employee.getEmpId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setAddress(employee.getAddress());
        employeeDao.saveEmployee(employeeEntity);
        try {
            restTemplate.postForObject("http://localhost:8080/api/dep/save", employee.getDepartment(), ResponseEntity.class);
        }catch (Exception e){
            throw new RestTemplateException("Exception while save department");

        }


        return "successService";
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employeeList=new ArrayList<>();
        List<EmployeeEntity> employeeEntities=employeeDao.getAllEmployees();
        for(EmployeeEntity employeeEntity:employeeEntities){
            Employee employee=new Employee();
            employee.setEmpId(employeeEntity.getEmpId());
            employee.setFirstName(employeeEntity.getFirstName());
            employee.setLastName(employeeEntity.getLastName());
            employee.setSalary(employeeEntity.getSalary());
            employee.setAddress(employeeEntity.getAddress());

            employeeList.add(employee);
        }
        return employeeList;
    }
    public Employee getEmployeeId(Integer empId){
        Employee employee=new Employee();
        EmployeeEntity employeeEntity= employeeDao.getEmployeeId(empId);
            employee.setEmpId(employeeEntity.getEmpId());
            employee.setFirstName(employeeEntity.getFirstName());
            employee.setLastName(employeeEntity.getLastName());
            employee.setSalary(employeeEntity.getSalary());
            employee.setAddress(employeeEntity.getAddress());
            return employee;

    }
}
