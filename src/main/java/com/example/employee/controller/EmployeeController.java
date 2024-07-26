package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController

public class EmployeeController {
    @Autowired
    public EmployeeH2Service employeeservice;

    @GetMapping("/employees)")
    ArrayList<Employee> getAllEmployees() {
        return employeeservice.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")

    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeservice.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")

    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeservice.addEmployee(employee);
    }

    @PutMapping("/employees")

    public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
        return employeeservice.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees")

    public void deleteEmployee(int employeeId) {
        employeeservice.deleteEmployee(employeeId);
    }

}
