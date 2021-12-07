package com.example.expenses.controller;

import com.example.expenses.model.Employee;
import com.example.expenses.service.EmployeeServiceImpl;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @InjectMocks private EmployeesController employeesController;

    private MockMvc mockMvc;

    @Mock EmployeeServiceImpl underTest;

    @Before
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeesController).build(); //gives a mock mvc for testing
    }

    @Test
    @SneakyThrows
    void getEmployeesTest(){
        Employee employee = new Employee(1L, "dikshya", "dikshya@gmail.com");
        List<Employee> employees = new ArrayList<Employee>();
        //employees.add(employee);
        when(underTest.getEmployees()).thenReturn(employees);

        this.mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(content().
                        json("{'id':1,'name':'dikshya','email':'dikshya@gmail.com'}"));

        verify(underTest).getEmployees();
    }

    @Test
    @Disabled
    void registerNewEmployee() {
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