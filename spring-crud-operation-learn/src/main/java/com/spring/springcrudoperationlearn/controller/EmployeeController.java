package com.spring.springcrudoperationlearn.controller;

import com.spring.springcrudoperationlearn.entity.Employee;
import com.spring.springcrudoperationlearn.exception.CustomErrorResponse;
import com.spring.springcrudoperationlearn.exception.CustomSuccessResponse;
import com.spring.springcrudoperationlearn.repository.EmployeeRepository;
import com.spring.springcrudoperationlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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



//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
@GetMapping("/employees")
public ResponseEntity<?> getAllEmployees() {
    try {
        List<Employee> employees = employeeService.getAllEmployees();
        return buildSuccessResponse(HttpStatus.OK, "Employees retrieved successfully", employees);
    } catch (Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve employees: " + ex.getMessage());
    }
}

//    @PostMapping("/employees")
//    public  Employee createEmployee(@RequestBody Employee employee)
//    {
//        return employeeService.createEmployee(employee);
//    }

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            Employee createdEmployee = employeeService.createEmployee(employee);
            return buildSuccessResponse(HttpStatus.CREATED, "Employee created successfully", createdEmployee);
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create employee: " + ex.getMessage());
        }
    }

//    @GetMapping("/employees/{id}")
//    public Optional<Employee> retrieveEmpById(@PathVariable int id)
//    {
//        return employeeService.retrieveEmployeeById(id);
//    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> retrieveEmpById(@PathVariable int id) {
        try {
            Optional<Employee> employee = employeeService.retrieveEmployeeById(id);
            if (employee.isPresent()) {
                return buildSuccessResponse(HttpStatus.OK, "Employee retrieved successfully", employee.get());
            } else {
                return buildErrorResponse(HttpStatus.NOT_FOUND, "Employee not found with ID: " + id);
            }
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve employee: " + ex.getMessage());
        }
    }


//    @PutMapping("/employees/{id}")
//    public Employee updateEmpById(@PathVariable Long id,@RequestBody Employee employee)
//    {
//        return employeeService.updateEmployeeById(id,employee);
//    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmpById(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployeeById(id, employee);
            return buildSuccessResponse(HttpStatus.OK, "Employee updated successfully", updatedEmployee);
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update employee: " + ex.getMessage());
        }
    }

//    @DeleteMapping("/employees/{id}")
//    public void deleteEmpById(@PathVariable Long id)
//    {
//         employeeService.deleteEmployeeById(id);
//    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmpById(@PathVariable Long id) {
        try {
            employeeService.deleteEmployeeById(id);
            return buildSuccessResponse(HttpStatus.OK, "Employee deleted successfully", null);
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete employee: " + ex.getMessage());
        }
    }

    private ResponseEntity<?> buildErrorResponse(HttpStatus status, String message) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(status.value(), message, LocalDateTime.now());
        return ResponseEntity.status(status).body(errorResponse);
    }

    private ResponseEntity<?> buildSuccessResponse(HttpStatus status, String message, Object data) {
        CustomSuccessResponse successResponse = new CustomSuccessResponse(status.value(), message, LocalDateTime.now(), data);
        return ResponseEntity.status(status).body(successResponse);
    }





}
