package com.payrollapi.api.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.payrollapi.api.entity.employeeSalaryEntity;


public interface EmployeeSalaryRepository extends JpaRepository<employeeSalaryEntity, Integer> 
{

	@Query("SELECT COUNT(DISTINCT e.employee.empId) FROM employeeSalaryEntity e")
    int findDistinctEmployeeCount();

    @Query("SELECT AVG(e.basicSalary) FROM employeeSalaryEntity e")
    BigDecimal findAverageBasicSalary();

    List<employeeSalaryEntity> findByIsDelayed(boolean isDelayed);
    
    @Query("SELECT e.employee.department, AVG(e.basicSalary) FROM employeeSalaryEntity e GROUP BY e.employee.department")
    List<Object[]> findAverageSalaryByDepartment();
    
    @Query("SELECT SUM(e.basicSalary + e.allowances - e.deductions) FROM employeeSalaryEntity e")
    BigDecimal sumTotalPayouts();

    @Query("SELECT COALESCE(SUM(es.basicSalary + es.allowances - es.deductions), 0) FROM employeeSalaryEntity es WHERE es.isDelayed = true")
    BigDecimal sumSalaryByIsDelayed(boolean isDelayed);
    
}



