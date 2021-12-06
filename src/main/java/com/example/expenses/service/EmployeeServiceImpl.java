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
        return employeeRepository.findById(id).orElse(null);
    }

    @SneakyThrows
    public void registerNewEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }

    @SneakyThrows
    public void updateEmailById(String newEmail, Long id) {
       Employee employee = employeeRepository.getById(id);
            if (employee != null){

                employee.setEmail(newEmail);
                if (employeeRepository.save(employee).getEmail().equals(newEmail))
                    System.out.println("Email updated successfully");
            }
    }

    @SneakyThrows
    public void deleteEmployeeById(Long id) {
       Employee employee = employeeRepository.getById(id);
       if (employee != null){

            employeeRepository.deleteById(id);
            if (employeeRepository.getById(id) == null)
                System.out.println("Employee deleted successfully");
        }

    }
}
