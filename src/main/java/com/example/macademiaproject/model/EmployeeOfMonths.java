package com.example.macademiaproject.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employeeofmonths")
public class EmployeeOfMonths{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="national_id")
    private String nationalId;


    private String name;

    private String surname;

    private Integer salary;

    @Column(name="start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    private String office;

    private String department;


//    @NonNull
//    @ManyToOne(optional = false)
//    @JoinColumn(name="employee_id", referencedColumnName="id")
//    private Employee employee;


    public EmployeeOfMonths(Employee random) {

     this.name = random.getName();
     this.surname=random.getSurname();
     this.nationalId=random.getNationalId();
     this.startDate=random.getStartDate();
     this.salary=random.getSalary();
     this.office=random.getOffice();
     this.department=random.getDepartment();




    }
}
