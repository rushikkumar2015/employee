package com.example.employee.model;

import com.example.employee.model.Employee;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
  @Override
  public Employee mapRow(ResultSet rs,int rowNum){
        return new Employee(
            rs.getInt("employeeId"),
            rs.getString("employeeName"),
            rs.getString("email"),
            rs.getString("department")
        )
    }
}
