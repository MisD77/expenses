package com.example.expenses.repository;

import com.example.expenses.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository underTest;

    @Test
    void itShouldCheckIfEmployeeExistsByEmail() {

        //given the employee and email
        String email = "jdoe@gmail.com";
        Employee employee = new Employee(1L,
                "jackie",
                email);
        underTest.save(employee);

        //when the email is expected
        Boolean expected = underTest.selectExistsEmail(email);

        //then assert it's true
        assertThat(expected).isTrue();
    }
}