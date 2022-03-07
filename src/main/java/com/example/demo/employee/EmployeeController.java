package com.example.demo.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/emp")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping(path = "{empId}")
    public List<Employee> getEmployeesId(@PathVariable("empId") Long id){
        return employeeService.getEmployeesById(id);
    }

    @PostMapping
    public void addEmp(@RequestBody Employee employee){
        employeeService.addEmp(employee);
    }

    @DeleteMapping(path = "{empId}")
    public void deleteEmp(@PathVariable("empId") Long id){
        employeeService.deleteEmp(id);
    }

    @PutMapping(path = "{empId}")
    public void updateEmp(
            @PathVariable("empId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String pos){
        employeeService.updateEmp(id, name, email, pos);
    }
}
