package com.stackroute.springmongodb.service;

import com.stackroute.springmongodb.domain.Employee;
import com.stackroute.springmongodb.exception.EmployeeAlreadyExistsException;
import com.stackroute.springmongodb.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;
   /* Logger logger  = LoggerFactory.getLogger("EmployeeServiceImpl.class");*/

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException {
        Optional<Employee> optional = employeeRepository.findById(employee.getEmpId());
        if (optional.isPresent()) {
           /* logger.info(String.valueOf(optional.isPresent()));*/
            throw new EmployeeAlreadyExistsException("Employee already exists");
        }
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeeByNameStartingWith(String name) {
        return employeeRepository.findByempNameStartingWith(name);
    }

    @Override
    public List<Employee> getAllEmployeesFromCity(String city) {
        return employeeRepository.findAllEmployeesFromCity(city);
    }
}
