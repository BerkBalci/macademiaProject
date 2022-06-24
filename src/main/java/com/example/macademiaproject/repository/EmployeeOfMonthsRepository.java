package com.example.macademiaproject.repository;

import com.example.macademiaproject.model.EmployeeOfMonths;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeOfMonthsRepository extends JpaRepository <EmployeeOfMonths,Integer> {
}
