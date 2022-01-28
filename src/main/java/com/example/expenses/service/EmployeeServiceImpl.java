package com.example.expenses.service;

import com.example.expenses.model.Employee;
import com.example.expenses.repository.EmployeeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @SneakyThrows
    public Employee registerNewEmployee(Employee employee)
    {
        employeeRepository.save(employee);
        return employee;
    }

    @SneakyThrows
    public ResponseEntity<Employee> testAvro(Employee employee)
    {
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/avro+json");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<Employee> response =  restTemplate.exchange("https://localhost:8080/api/v1/employees", HttpMethod.POST, entity, Employee.class);
       // ResponseEntity<Employee> response = restTemplate.exchange("https://localhost:8080/api/v1/employees",entity,  HttpMethod.POST, request, Employee.class);
        return response;
    }

/*
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
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

        }*/
}
