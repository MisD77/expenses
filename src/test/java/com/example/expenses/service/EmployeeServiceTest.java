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
class EmployeeServiceTest {


    @Mock private EmployeeRepository employeeRepository;
    private EmployeeService underTest;


    //this runs before each test
    @BeforeEach
    void setUp() {
        underTest = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void getEmployeesTest() {
        //given the employee and email
        String email = "jdoe@gmail.com";
        Employee employee = new Employee(1L,
                "jackie",
                email);
        //when
        underTest.getEmployees();
        //then verify our mock which is employeeRepository and fail
        verify(employeeRepository).findAll();

    }

    @Test
    void registerNewEmployeeTest() {
        //given the employee and email
        String email = "jdoe@gmail.com";
        Employee employee = new Employee(1L,
                "jackie",
                email);

        //when
        underTest.registerNewEmployee(employee);

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor =
                ArgumentCaptor.forClass(Employee.class);

        verify(employeeRepository).save(employeeArgumentCaptor.capture());

        Employee capturedEmployee = employeeArgumentCaptor.getValue();

        assertThat(capturedEmployee).isEqualTo(employee);
    }

    //when email exists
    /*@Test
    void shouldNotRegisterEmployeeIfEmailExists() {
        //given the employee and email
        String email = "jdoe@gmail.com";
        Employee employee = new Employee(1L,
                "jackie",
                email);

        given(employeeRepository.selectExistsEmail(employee.getEmail())).willReturn(true);

        //when
        //then
        assertThatThrownBy(() -> underTest.registerNewEmployee(employee)).
                isInstanceOf(BadRequestException.class).
                hasMessageContaining("Email " + employee.getEmail() + " taken, hence employee cannot be added");

        verify(employeeRepository, never()).save(any());

    }
*/

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