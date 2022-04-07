package com.example.employeemangementbackend.Service;

import com.example.employeemangementbackend.Model.Employee;
import com.example.employeemangementbackend.Repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepo employeeRepo;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService=new EmployeeService(employeeRepo);
    }

    @Test
    void addEmployee() {
        //given
        Employee employee=
                new Employee(1,"Nainavee","abc@gmail.com","9685748596","CEO","abc.com");
        //when
        employeeService.addEmployee(employee);

        //then
        ArgumentCaptor<Employee> argumentCaptor=ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepo).save(argumentCaptor.capture());
        Employee capturedEmployee = argumentCaptor.getValue();
        assertThat(capturedEmployee).isEqualTo(employee);

    }

    @Test
    void getEmployees() {
        //when
        employeeService.getEmployees();
        //then
        verify(employeeRepo).findAll();


    }

    @Test
    void getEmployeeById() {
//        //given
//        Employee employee=
//                new Employee(1,"Nainavee","abc@gmail.com","9685748596","CEO","abc.com");
//        //when
//        employeeRepo.save(employee);
//        //when
//        employeeService.getEmployeeById(1);
//        //then
//        ArgumentCaptor<Integer> argumentCaptor=ArgumentCaptor.forClass(Integer.class);
//        verify(employeeRepo).findById(argumentCaptor.capture());
//        Integer value = argumentCaptor.getValue();
//        assertThat(value).isEqualTo(1);
        //given
        Employee employee=
                new Employee(1,"Nainavee","abc@gmail.com","9685748596","CEO","abc.com");
        //when
        employeeService.addEmployee(employee);
        employeeService.getEmployeeById(1);

        //then
        verify(employeeRepo.findById(1));
    }

    @Test
    @Disabled
    void updateEmployee() {
    }

    @Test
    @Disabled
    void deleteEmployee() {
    }

    @Test
    @Disabled
    void findByEmail() {
    }
}