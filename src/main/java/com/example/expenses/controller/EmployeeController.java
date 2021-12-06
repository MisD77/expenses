package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController {

    //when adding service layer between controller and repository
    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl)
    {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    //get method to get all employees using the url from db
    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeServiceImpl.getEmployees();
    }

    //post method to get add employee into the db
    @PostMapping
    public void registerNewEmployee(@RequestBody List<Employee> employee)
    {
        for (Employee e: employee)
        {
            employeeServiceImpl.registerNewEmployee(e);
        }
    }

    //get method to get an employee by a given id
    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
       return employeeServiceImpl.getEmployeeById(id);
    }

    /*
     put method to update the employee email(or anything else name etc using id)
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