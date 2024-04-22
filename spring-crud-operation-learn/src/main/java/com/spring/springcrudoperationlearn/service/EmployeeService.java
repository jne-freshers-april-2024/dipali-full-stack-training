package com.spring.springcrudoperationlearn.service;

import com.spring.springcrudoperationlearn.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Optional<Employee> retrieveEmployeeById(int id);

    Employee updateEmployeeById(Long id, Employee updatedEmployee);

    void deleteEmployeeById(Long id);



}
