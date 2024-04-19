package com.spring.springcrudoperationlearn.controller;

import com.spring.springcrudoperationlearn.entity.Employee;
import com.spring.springcrudoperationlearn.repository.EmployeeRepository;
import com.spring.springcrudoperationlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

//    Create a REST controller for managing employee resources.
//   - Implement endpoints for CRUD operations:
//            - GET /employees - Retrieve all employees
//     - GET /employees/{id} - Retrieve an employee by ID
//     - POST /employees - Create a new employee
//     - PUT /employees/{id} - Update an existing employee
//     - DELETE /employees/{id} - Delete an employee by ID



    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public  Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> retrieveEmpById(@PathVariable int id)
    {
        return employeeService.retrieveEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmpById(@PathVariable Long id,@RequestBody Employee employee)
    {
        return employeeService.updateEmployeeById(id,employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmpById(@PathVariable Long id)
    {
         employeeService.deleteEmployeeById(id);
    }






}
