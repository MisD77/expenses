package com.example.expenses.service;

import com.example.expenses.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(Long id);
    Employee registerNewEmployee(Employee employee);
    Employee updateEmailById(String newEmail, Long id);
    void deleteEmployeeById(Long id);

    List<Employee> getEmployees();
}
