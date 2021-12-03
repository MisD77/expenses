package com.example.expenses.service;

import com.example.expenses.model.Employee;
import com.example.expenses.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    /*
        This step is nice to have, add a service layer that communicates between api and data layer, but skipped for now
    */

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void registerNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

   public void updateEmailById(String newEmail, Long id) {
       try {

           Employee employee = employeeRepository.getById(id);
           if (employee != null) {
               employee.setEmail(newEmail);
               if (employeeRepository.save(employee).getEmail().equals(newEmail)) {
                   System.out.println("Email updated successfully");
               }
           }
       } catch (Exception e) {
           System.out.println("Error updating email");
       }
   }

    public void deleteEmployeeById(Long id) {
        try{
                Employee employee = employeeRepository.getById(id);
                if (employee != null)
                {
                    employeeRepository.deleteById(id);
                    if (employeeRepository.getById(id) == null)
                    {
                        System.out.println("Employee deleted successfully");
                    }
                }
        }
        catch(Exception e)
        {
            System.out.println("Error deleting employee");
        }

    }
}
