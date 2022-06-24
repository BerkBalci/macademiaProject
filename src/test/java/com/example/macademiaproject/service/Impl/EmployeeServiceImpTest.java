package com.example.macademiaproject.service.Impl;

import com.example.macademiaproject.model.Employee;
import com.example.macademiaproject.model.EmployeeOfMonths;
import com.example.macademiaproject.model.dto.EmployeeDTO;
import com.example.macademiaproject.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImpTest {

    @Mock
    private EmployeeRepository employeeRepository;


    @InjectMocks
    private EmployeeServiceImp employeeService;

    @Test
    void getAllEmployees() {

        Employee employee1 = new Employee (1, "74851728384" ,"Employee1" , "Lastname1", 5000, new Date(), "Kadıkoy", "Development");
        Employee employee2 = new Employee (2,"17273848596" ,"Employee2", "Lastname2",1000,new Date(), "Besiktas", "Marketing");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        when(employeeRepository.findAll()).thenReturn(employees);


        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();

        Assert.assertEquals(employees.size(), allEmployees.size());
    }

    @Test
    void searchEmployees() {
    }

    @Test
    void updateOffice() {
    }

    @Test
    void selectEmployee() {
    }

    @Test
    void getEmployee() {
    }

    @Test
    void addEmployee() {
        Employee expectedEmployee = new Employee(1, "74851728384" ,"Employee1" , "Lastname1", 5000, new Date(), "Kadıkoy", "Development");


        when(employeeRepository.save(expectedEmployee)).thenReturn(expectedEmployee);


        employeeService.addEmployee(expectedEmployee);


        verify(employeeRepository, times(1)).save(expectedEmployee);
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {


    }
}