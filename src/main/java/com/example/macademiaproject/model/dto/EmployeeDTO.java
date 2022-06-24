package com.example.macademiaproject.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {

    private String nationalId;
    private String name;
    private String surname;
    private Integer salary;
    private Date startDate;
    private String office;
    private String department;


}
