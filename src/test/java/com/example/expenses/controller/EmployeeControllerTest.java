package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeesController.class)
class EmployeeControllerTest {

    @MockBean
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

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
        String StringContent = mapToJson(employee);

        mockMvc.perform(post("/api/v1/employees/")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(StringContent))
                  .andExpect(status().isOk());


    }

    @Test
    @SneakyThrows
    void updateEmailById() {
        String stringContent = "newEmail@gmail.com";
        mockMvc.perform(put("/api/v1/employees/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(stringContent))
                        .andExpect(status().isOk());

    }

}