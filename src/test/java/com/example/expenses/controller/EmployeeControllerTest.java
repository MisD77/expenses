package com.example.expenses.controller;

import com.example.expenses.service.EmployeeServiceImpl;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
class EmployeeControllerTest {

    private MockMvc mockMvc;
  /*  @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
*/
    //@InjectMocks private EmployeesController employeesController;

    @Before
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        //employeesController = new EmployeesController(employeeServiceImpl);
        mockMvc = MockMvcBuilders.standaloneSetup(new employeesController().build()); //gives a mock mvc for testing
    }

    @Test
    @SneakyThrows
    void getEmployeesTest(){
        /*Employee employee = new Employee(1L, "dikshya", "dikshya@gmail.com");
        List<Employee> employees = new ArrayList<Employee>(1);
        employees.add(employee);*/
        //when(employeeServiceImpl.getEmployees()).thenReturn(employees);

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'name':'dikshya','email':'dikshya@gmail.com'}]"));

        //verify(employeeServiceImpl).getEmployees();
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