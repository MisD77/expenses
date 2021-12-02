package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController {

    @GetMapping
    public List<Employee> getEmployees()
    {
        return List.of(
                new Employee(1L, "dikshya", "dixyacharya@gmail.com")
        );
    }

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
