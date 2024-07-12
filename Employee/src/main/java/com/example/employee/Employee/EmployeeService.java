package com.example.employee.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();

    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional=employeeRepository( employee );

        employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (employeeOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        employeeRepository.save(employee);
        System.out.println(employee);
    }

    private Optional<Employee> employeeRepository(Employee employee) {

        return null;
    }

    public void deleteEmployee(Long employeeId) {
       boolean exists= employeeRepository.existsById(employeeId);
       if(!exists){
           throw new IllegalStateException(
                   "employee with id"+employeeId+"does not exist");
       }
       employeeRepository.deleteById(employeeId);

    }
/*@Transactional
    public void updateEmployee(Long employeeId, String name, String email) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()-> new IllegalStateException(
                        "employee with id"+employeeId+"does not exist");
                if ()

    }*/
}
