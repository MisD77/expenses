package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    /*
    public int getEmpCount()
    {
        return 0;
    }*/

   /* @GetMapping
    public Employee getEmployeeById(Long id)
    {
        //return employee that matches with the id
    }

    @PostMapping
    public void addEmployee(Employee employee)
    {
        //check if id exists
        //post if not
    }
*/
}
