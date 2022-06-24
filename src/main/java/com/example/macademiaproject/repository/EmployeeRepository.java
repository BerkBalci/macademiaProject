package com.example.macademiaproject.repository;

import com.example.macademiaproject.model.Employee;
import com.example.macademiaproject.model.EmployeeOfMonths;
import com.example.macademiaproject.model.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>, QueryByExampleExecutor<Employee> {

    @Transactional
    @Modifying
    @Query("update Employee u set u.office = :office where u.department = :department")
    void assignOffice(@Param(value = "department") String department, @Param(value = "office") String office);

    @Transactional
    @Modifying
    @Query("Select e FROM Employee e  " +
            "where " +
            " (:startDate is NULL or e.startDate > :startDate) " +
            " AND " +
            " (:salary is NULL or e.salary > :salary) ")
    void searchEmployees(@Param(value = "startDate") Date startDate, @Param(value = "salary") Integer salary);

}
