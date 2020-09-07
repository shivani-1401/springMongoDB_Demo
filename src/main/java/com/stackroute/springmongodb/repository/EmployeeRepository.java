package com.stackroute.springmongodb.repository;

import com.stackroute.springmongodb.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public List<Employee> findByempNameStartingWith(String name);

    @Query("{'address.city': {$in : [?0]}}")
    public List<Employee> findAllEmployeesFromCity(String city);
}
