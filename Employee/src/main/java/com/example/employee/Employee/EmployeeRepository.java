package com.example.employee.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends
        JpaRepository<Employee,Long> {

    Optional<Employee>findEmployeeByEmail(String email);
}
