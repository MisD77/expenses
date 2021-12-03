package com.example.expenses.service;

import com.example.expenses.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


class EmployeeServiceTest {


    @Mock private EmployeeRepository employeeRepository;
    private AutoCloseable autoCloseable;
    private EmployeeService underTest;

    //this runs before each test
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmployeeService(employeeRepository);
    }

    //allows us to close after test
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
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