package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*//get method to get all employees using the url from db
     @GetMapping(value = "/", produces ="application/avro+json", consumes = "application/avro+json")
    public List<Employee> getEmployees()
    {
        System.out.println("Hello getEmployees");
        return employeeServiceImpl.getEmployees();
    }

    //post method to get add employee into the db
    @PostMapping(value = "/", produces = "application/avro+json")
    public Employee registerNewEmployee(@RequestBody Employee employee)
    {
        employeeServiceImpl.registerNewEmployee(employee);
        return employee;
    }*/

    @GetMapping(value = "/start")
    public ResponseEntity<Employee> start(Employee employee)
    {
        System.out.println("Hello");
        return employeeServiceImpl.testAvro(employee);
    }

    @PostMapping(value = "/", produces = "application/avro+json")
    public Employee avroEcho(@RequestBody Employee employee)
    {
        System.out.println("Hello avroEcho");
        return employee;
    }



   /* //get method to get an employee by a given id
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(@PathVariable Long id)
    {
       return employeeServiceImpl.getEmployeeById(id);
    }

    *//*
     put method to update the employee email(or anything else name using id)
     find the employee using get request by id, then updates in database
    *//*
    @PutMapping(path="update/{id}")
    public void updateEmailById(@RequestBody String newEmail, @PathVariable  Long id)
    {
       employeeServiceImpl.updateEmailById(newEmail, id);

    }

    //delete method to delete an employee from database
    @DeleteMapping(path="delete/{id}")
    public void deleteEmployeeById(@PathVariable Long id)
    {
        employeeServiceImpl.deleteEmployeeById(id);
    }*/


}