package com.example.employee.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {
    private final EmployeeRepository repository;

    public EmployeeConfig(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

           Employee ruth= new Employee(
                    "ruth",
                    "ruth@gmail.com",
                    LocalDate.of(1999, Month.OCTOBER,10)

            );
            Employee Alex= new Employee(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,15)
            );
            repository.saveAll(
                    List.of(ruth,Alex)
            );




        };
    }
}
