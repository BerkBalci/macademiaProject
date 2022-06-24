package com.example.macademiaproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name="national_id")
    private String nationalId;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private Integer salary;

    @Column(name="start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    private String office;

    private String department;


//    @OneToMany(
//            mappedBy = "employee",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<EmployeeOfMonths> employeeOfMonths;

}
