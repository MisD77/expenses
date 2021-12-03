package com.example.expenses.service;

import com.example.expenses.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {


    @Mock private EmployeeRepository employeeRepository;
    private EmployeeService underTest;

    //this runs before each test
    @BeforeEach
    void setUp() {
        underTest = new EmployeeService(employeeRepository);
    }

    @Test
    void getEmployeesTest() {
        //when
        underTest.getEmployees();
        //then verify our mock which is employeeRepository and fail
        verify(employeeRepository).findAll();

    }

    @Test
    @Disabled
    void getEmployeeById() {
    }

    @Test
    @Disabled
    void registerNewEmployee() {
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