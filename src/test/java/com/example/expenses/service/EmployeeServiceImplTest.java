package com.example.expenses.service;

import com.example.expenses.model.Employee;
import com.example.expenses.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

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
        ArgumentCaptor<Employee> employeeArgumentCaptor =
                ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeArgumentCaptor.capture());
        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        assertThat(capturedEmployee).isEqualTo(employee);
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