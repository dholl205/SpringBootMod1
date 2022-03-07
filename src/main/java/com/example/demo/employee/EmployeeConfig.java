package com.example.demo.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {

            Employee Joe = new Employee(
                    1L,
                    "Joe",
                    "JoeMama@gmail.com",
                    "CEO",
                    LocalDate.of(1987, JUNE, 15)

            );
            Employee Daelan = new Employee(
                    2L,
                    "Daelan",
                    "dholl205@gmail.com",
                    "Software Dev",
                    LocalDate.of(2002, OCTOBER, 2)
            );
            employeeRepository.saveAll(List.of(Joe, Daelan));
        };
    }
}
