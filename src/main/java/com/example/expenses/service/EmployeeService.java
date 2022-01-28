package com.example.expenses.service;

import com.example.expenses.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    Employee registerNewEmployee(Employee employee);

  /*  Employee getEmployeeById(Long id);
    void updateEmailById(String newEmail, Long id);
    void deleteEmployeeById(Long id);*/

}
