package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/employees")
public class EmployeesController {

    //when adding service layer between controller and repository
    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeesController(EmployeeServiceImpl employeeServiceImpl)
    {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    //get method to get all employees using the url from db
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees()
    {
        return employeeServiceImpl.getEmployees();
    }

    //post method to get add employee into the db
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    public Employee registerNewEmployee(@RequestBody Employee employee)
    {
        employeeServiceImpl.registerNewEmployee(employee);
        return employee;
    }

    //get method to get an employee by a given id
    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
       return employeeServiceImpl.getEmployeeById(id);
    }

    /*
     put method to update the employee email(or anything else name using id)
     find the employee using get request by id, then updates in database
    */
    @PutMapping(path="update/{id}")
    public void updateEmailById(@RequestBody String newEmail, @PathVariable Long id)
    {
        employeeServiceImpl.updateEmailById(newEmail, id);
    }

    //delete method to delete an employee from database
    @DeleteMapping(path="delete/{id}")
    public void deleteEmployeeById(@PathVariable Long id)
    {
        employeeServiceImpl.deleteEmployeeById(id);
    }
}