package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }


    public void addEmp(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Email is taken.");
        }
        employeeRepository.save(employee);

    }

    public void deleteEmp(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + id + " does not exist.");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmp(Long id, String name, String email, String pos) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Employee with id " + id + " does not exist."
        ));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(employee.getEmail(), email)) {
            employee.setEmail(email);
        }
        if (pos != null &&
                pos.length() > 0 &&
                !Objects.equals(employee.getPos(), pos)) {
            employee.setPos(pos);
        }
    }

    public List<Employee> getEmployeesById(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + id + " does not exist.");
        }
        return employeeRepository.findAllById(Collections.singleton(id));
    }
}
