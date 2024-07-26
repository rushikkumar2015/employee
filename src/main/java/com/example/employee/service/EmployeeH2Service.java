package com.example.employee.service;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeH2Service;
import com.example.employee.repository.EmployeeRepository; 
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.HttpStatus;
  import org.springframework.jdbc.core.JdbcTemplate;
  import org.springframework.stereotype.Service;
  import org.springframework.web.server.ResponseStatusException;
  import java.util.ArrayList;

  @Service
  public EmployeeH2Service implements EmployeeRepository{
    @Autowired 
    private JdbcTemplate db;
    @Override 
    ArrayList<Employee> getAllEmployees(){
        return (ArrayList<Employee>) db.query("select * from employeelist",new employeeRowMapper());
    }
    @Override
    Employee getEmployeeById(int employeeId){
        try{
            return db.queryForObject("select * form employeelist where employeeId=?",new employeeRowMapper(),employeeId);
        }catch(Exception e){
            new throw ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    Employee addEmployee(Employee employee){
        db.update("insert into employeelist(employeeName,email,department) values(?,?,?)",employee.getEmployeeName(),
        employee.getEmail(),employee.getDepartment());
        return db.queryForObject("select form employeelist where employeeName=? and email=?",employee.getEmployeeName(),
        
        
    }
    @Override
    void deleteEmployee(int employeeId){
        db.update("delete from employeelist where employeeId=?",employeeId);
    }
    @Override
    Employee updateEmployee(int employeeId,Employee employee){
        if(employee.getEmployeeName() != null){
            db.update("update  employeelist set employeeName=? where employeeId=?",employee.getEmployeeName(),employeeId);
        }
        if(employee.getEmail()!=null){
            db.update("update employeelist set email=? where employeeId=?",employee.getEmail(),employeeId);
        }
        if(employee.getDepartment()!=null){
            db.update("update employeelist set department=? where employeeId=?" employee.getDepartment(),employeeId);
        }
        return getEmployeeById(employeeId);
    }

  }
