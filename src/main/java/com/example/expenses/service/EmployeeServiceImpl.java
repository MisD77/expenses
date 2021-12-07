package com.example.expenses.service;

import com.example.expenses.model.Employee;
import com.example.expenses.repository.EmployeeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);//.orElse(null);
    }

    @SneakyThrows
    public Employee registerNewEmployee(Employee employee)
    {
        employeeRepository.save(employee);
        return employee;
    }

    @SneakyThrows
    public void updateEmailById(String newEmail, Long id) {
       Employee employee = employeeRepository.getById(id);//.orElse(null);
           if (employee != null){
                employee.setEmail(newEmail);
                employeeRepository.save(employee);
            }
    }

    @SneakyThrows
    public void deleteEmployeeById(Long id) {
       Employee employee = employeeRepository.getById(id);//.orElse(null);
       if (employee != null){
            employeeRepository.delete(employee);
          if (employeeRepository.getById(id) == null)
                System.out.println("Employee deleted successfully");
        }

    }
}
