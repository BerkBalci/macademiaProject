package com.example.macademiaproject.Controller;

import com.example.macademiaproject.model.Employee;
import com.example.macademiaproject.model.EmployeeOfMonths;
import com.example.macademiaproject.model.dto.EmployeeDTO;
import com.example.macademiaproject.model.mapper.EmployeeMapper;
import com.example.macademiaproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/get")
    public EmployeeDTO getEmployee(@RequestParam Integer id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping(path = "/add")
    public boolean addCEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.addEmployee(EmployeeMapper.toEntity(employee));
    }


    @PutMapping(value = "/update/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Integer id,
                                      @RequestBody EmployeeDTO employee) {
        return employeeService.updateEmployee(id, EmployeeMapper.toEntity(employee));
    }

    @DeleteMapping(value = "/delete/id={id}")
    public boolean deleteEmployee(@PathVariable Integer id) {

        return employeeService.deleteEmployee(id);
    }


    @GetMapping(path="/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                          @RequestParam("salary") Integer salary) {

        employeeService.searchEmployees(startDate,salary);
        return null;
    }


    @PutMapping(path="/assign")
    public List<EmployeeDTO> assignOffice(@RequestParam("department")  String department,
                                                       @RequestParam(required=false,name="office")  String office){
        employeeService.updateOffice(department,office);

        return employeeService.getAllEmployees();

    }
    @Scheduled(cron = "0 15 10 15 * ?", zone = "Europe/Istanbul")
    @GetMapping(path="/month")
    public EmployeeDTO selectEmployee(Employee employee,EmployeeOfMonths employeeOfMonths){
        return employeeService.selectEmployee(employee,employeeOfMonths);
    }
}