package com.example.employee.repository;

import java.util.ArrayList;
import com.example.employee.model.Employee;
import com.example.employee.repository;

public interface EmployeeRepository {
    ArrayList<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(int employeeId, Employee employee);

    void deleteEmployee(int employeeId);

}