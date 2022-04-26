package com.kiranit.employee.controller;

import com.kiranit.employee.domain.Employee;
import com.kiranit.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("save")
    public ResponseEntity saveEmployee(@RequestBody Employee employee ){
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(200).body("SUCCESS");
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList=employeeService.getAllEmployees();

        return new ResponseEntity <List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping("get/{employeeId}")
    public ResponseEntity<?> getEployeeId(@PathVariable int employeeId){
        Employee emloyeeRetrived=employeeService.getEmployeeId(employeeId);
        return new ResponseEntity<Employee>(emloyeeRetrived,HttpStatus.OK);
    }

}
