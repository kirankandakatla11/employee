package com.kiranit.employee.dao;

import com.kiranit.employee.entity.EmployeeEntity;
import com.kiranit.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao {
    @Autowired
    EmployeeRepository employeeRepository;

    public String saveEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);

        return "SUCCESSDAO";
    }

    public List<EmployeeEntity> getAllEmployees() {
        Iterable<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeList.forEach(employeeEntity -> employeeEntities.add(employeeEntity));
        return employeeEntities;
    }

    public EmployeeEntity getEmployeeId(Integer empId) {

        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(empId);
        EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
        return employeeEntity;

    }
}



