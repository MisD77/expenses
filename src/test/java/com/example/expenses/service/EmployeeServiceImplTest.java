package com.example.expenses.service;

import com.example.expenses.model.Employee;
import com.example.expenses.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock private EmployeeRepository employeeRepository;
    private EmployeeServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void getEmployeesTest() {
        //given the employee
        Employee expectedEmployee = new Employee(1L,
                "jackie",
                "jdoe@gmail.com");
        //when
        underTest.getEmployees();
        //then verify our mock which is employeeRepository and fail
        verify(employeeRepository).findAll();
    }

    @Test
    void getEmployeeByIdTest() {
        //given
        Employee employee = new Employee(1L,
                "jackie",
                "jdoe@gmail.com");
        //when
        underTest.getEmployeeById(1L);
        //then verify our mock which is employeeRepository and fail
        verify(employeeRepository).findById(1L);

    }

    @Test
    void getEmployeeByIdReturnsNullTest(){
        //given
        Employee employee = null;
        //when
        underTest.getEmployeeById(1L);
        //then verify our mock which is employeeRepository and fail
        verify(employeeRepository).findById(1L);
    }

    @Test
    void registerNewEmployeeTest() {
        //given
        Employee employee = new Employee(1L,
                "jackie",
                "jdoe@gmail.com");

        //when
        underTest.registerNewEmployee(employee);

        //then
        verify(employeeRepository).save(employee);
    }

    @Test
    void updateEmailByIdTest() {
        // Setup
        Employee employee = new Employee(0L, "dikshyaa", "email");

        when(employeeRepository.getById(0L)).thenReturn(employee);
        underTest.updateEmailById("hi", 1L);
        when(employeeRepository.save(employee)).thenReturn(employee);

    }

    @Test
    @Disabled
    void deleteEmployeeByIdTest() {
        //given
        Employee employee = new Employee(1L, "dikshya", "dixyach@gmail.com");

        //when
        underTest.deleteEmployeeById(1L);

        //then
        verify(employeeRepository).delete(employee);

    }
}