package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController {

    //when adding service layer between controller and repository
    public final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    /*
    if service layer was omitted then follow this:
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/

    //get method to get all employees using the url from db
    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }


    //post method to get add employee into the db
    @PostMapping
    public void registerNewEmployee(@RequestBody List<Employee> employee)
    {
        for (Employee e: employee)
        {
            employeeService.registerNewEmployee(e);
        }
    }


    //get method to get an employee by a given id
    @GetMapping(path = "getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
       return employeeService.getEmployeeById(id);
    }


    /*put method to update the employee email(or anything else name etc using id)
     find the employee using get request by id, then updates in database
     */
    @PutMapping(path="updateEmailById/{id}")
    public void updateEmailById(@RequestBody String newEmail, @PathVariable Long id)
    {
        employeeService.updateEmailById(newEmail, id);
    }


    //delete method to delete an employee from database
    @DeleteMapping(path="deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable Long id)
    {
        employeeService.deleteEmployeeById(id);
    }

}
