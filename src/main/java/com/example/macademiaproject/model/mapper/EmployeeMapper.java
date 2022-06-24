package com.example.macademiaproject.model.mapper;

import com.example.macademiaproject.model.Employee;
import com.example.macademiaproject.model.dto.EmployeeDTO;

public class EmployeeMapper {

    public static EmployeeDTO toDto(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setNationalId(employee.getNationalId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setStartDate(employee.getStartDate());
        employeeDTO.setOffice(employee.getOffice());
        employeeDTO.setDepartment(employee.getDepartment());

        return employeeDTO;

    }

    public static Employee toEntity(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setNationalId(employeeDTO.getNationalId());
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setSalary(employeeDTO.getSalary());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setOffice(employeeDTO.getOffice());
        employee.setDepartment(employeeDTO.getDepartment());


        return employee;

    }
}
