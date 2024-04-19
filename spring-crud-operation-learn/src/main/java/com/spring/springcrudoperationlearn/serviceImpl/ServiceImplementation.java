package com.spring.springcrudoperationlearn.serviceImpl;

import com.spring.springcrudoperationlearn.entity.Employee;
import com.spring.springcrudoperationlearn.repository.EmployeeRepository;
import com.spring.springcrudoperationlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class ServiceImplementation implements EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> retrieveEmployeeById(int id) {
        return employeeRepository.findById((long) id);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        // Set other fields if needed

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee existingEmployee = getEmployeeById(id);
        employeeRepository.delete(existingEmployee);
    }


    private Employee getEmployeeById(Long id) {
            return employeeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

    }


}
