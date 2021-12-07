package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeesController.class)
class EmployeeControllerTest {

    @MockBean
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void getEmployeesTest(){
        Employee employee = new Employee(1L, "dikshya", "dikshya@gmail.com");
        List<Employee> employees = new ArrayList<>();
        when(employeeServiceImpl.getEmployees()).thenReturn(employees);

        mockMvc.perform(get("/api/v1/employees/"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void registerNewEmployeeTest() {
        Employee employee = new Employee (1L, "dikshya", "dikshya@gmail.com");
        when(employeeServiceImpl.registerNewEmployee(employee)).thenReturn(employee);
        String StringContent = "{\"id\": \"1\"," +
                "\"name\": \"dikshya\"," +
                "\"email\": \"dikshya@gmail.com\"}";

        mockMvc.perform(post("/api/v1/employees/")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(StringContent))
                  .andExpect(status().isOk());
    }

    @Test
    @Disabled
    void getEmployeeById() {

    }

    @Test
    @Disabled
    void updateEmailById() {
    }

    @Test
    @Disabled
    void deleteEmployeeById() {
    }
}