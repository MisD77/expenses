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

    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody List<Employee> employee)
    {
        for (Employee e: employee)
        {
            employeeService.registerNewEmployee(e);
        }
    }

    @GetMapping(path = "getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
       return employeeService.getEmployeeById(id);
    }

    @PutMapping(path="updateEmailById/{id}")
    public void updateEmailById(@RequestBody String newEmail, @PathVariable Long id)
    {
        employeeService.updateEmailById(newEmail, id);
    }

   @DeleteMapping(path="deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable Long id)
    {
        employeeService.deleteEmployeeById(id);
    }

}
