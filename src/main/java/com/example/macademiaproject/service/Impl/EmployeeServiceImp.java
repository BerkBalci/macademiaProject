package com.example.macademiaproject.service.Impl;

import com.example.macademiaproject.model.Employee;

import com.example.macademiaproject.model.EmployeeOfMonths;
import com.example.macademiaproject.model.dto.EmployeeDTO;
import com.example.macademiaproject.model.mapper.EmployeeMapper;

import com.example.macademiaproject.repository.EmployeeOfMonthsRepository;
import com.example.macademiaproject.repository.EmployeeRepository;
import com.example.macademiaproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeOfMonthsRepository employeeOfMonthsRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> all = employeeRepository.findAll();
        return all.stream().map(EmployeeMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public void searchEmployees(Date startDate, Integer salary) {

        employeeRepository.searchEmployees(startDate, salary);

    }


    @Override
    public void updateOffice(String department, String office) {
        employeeRepository.assignOffice(department, office);

    }

    @Override
    public EmployeeDTO selectEmployee(Employee employee, EmployeeOfMonths employeeOfMonths) {
        List<Employee> all = employeeRepository.findAll();
        Random randomizer = new Random();
        Employee random = all.get(randomizer.nextInt(all.size()));
        employeeOfMonthsRepository.save(new EmployeeOfMonths(random));

        return EmployeeMapper.toDto(random);
    }



    @Override
    public EmployeeDTO getEmployee(Integer id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isPresent()) {
            return EmployeeMapper.toDto(byId.get());
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {

        Employee save = employeeRepository.save(employee);
        if (save == null)

            return false;
        return true;
    }

    @Override
    public EmployeeDTO updateEmployee(Integer id, Employee employee) {
        EmployeeDTO currentEmployee = getEmployee(id);
        if (currentEmployee == null)
            return null;
        employee.setId(id);
        return EmployeeMapper.toDto(employeeRepository.save(employee));

    }

    @Override
    public boolean deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return true;
    }




}