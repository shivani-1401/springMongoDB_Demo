package com.stackroute.springmongodb.controller;

import com.stackroute.springmongodb.domain.Employee;
import com.stackroute.springmongodb.exception.EmployeeAlreadyExistsException;
import com.stackroute.springmongodb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employeeservice")
public class EmployeeController {

    private IEmployeeService iEmployeeService;
    private ResponseEntity responseEntity;

    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = iEmployeeService.saveEmployee(employee);
            responseEntity = new ResponseEntity(savedEmployee, HttpStatus.OK);
        } catch (EmployeeAlreadyExistsException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = iEmployeeService.getAllEmployee();
        responseEntity = new ResponseEntity(employeeList, HttpStatus.FOUND);
        return responseEntity;
    }

    @GetMapping("/employees/{name}")
    public ResponseEntity<List<Employee>> getAllEmployeesNameStartingWith(@PathVariable String name) {
        List<Employee> employeeList = iEmployeeService.getAllEmployeeByNameStartingWith(name);
        responseEntity = new ResponseEntity(employeeList, HttpStatus.FOUND);
        return responseEntity;
    }

    @GetMapping("/employees/city/{city}")
    public ResponseEntity<List<Employee>> getAllEmployeesFromCity(@PathVariable String city) {
        List<Employee> employeeList = iEmployeeService.getAllEmployeesFromCity(city);
        responseEntity = new ResponseEntity(employeeList, HttpStatus.FOUND);
        return responseEntity;
    }


}
