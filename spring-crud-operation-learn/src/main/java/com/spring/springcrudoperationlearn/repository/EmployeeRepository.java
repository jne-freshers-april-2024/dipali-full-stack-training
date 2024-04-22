package com.spring.springcrudoperationlearn.repository;

import com.spring.springcrudoperationlearn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {




}
