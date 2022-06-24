package com.example.macademiaproject.service;

import com.example.macademiaproject.model.Employee;
import com.example.macademiaproject.model.EmployeeOfMonths;
import com.example.macademiaproject.model.dto.EmployeeDTO;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployee(Integer id);

    boolean addEmployee(Employee employee);

    EmployeeDTO updateEmployee(Integer id,Employee employee);

    boolean deleteEmployee(Integer id);

    EmployeeDTO selectEmployee(Employee employee,EmployeeOfMonths employeeOfMonths);

    void updateOffice(String department,String office);

    void searchEmployees(Date startDate,Integer salary);


}
