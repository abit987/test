package com.payrollapi.api.service;

//import com.payroll.api.entity.EmployeeSalaryEntity;
//import com.payroll.api.model.Employee;
import org.springframework.stereotype.Service;

import com.payrollapi.api.repositories.EmployeeRepository;
import com.payrollapi.api.repositories.EmployeeSalaryRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService 
{

    private final EmployeeRepository employeeRepository;
    private final EmployeeSalaryRepository employeeSalaryRepository;

    public DashboardService (EmployeeRepository employeeRepository, EmployeeSalaryRepository employeeSalaryRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeSalaryRepository = employeeSalaryRepository;
    }

    public Map<String, Object> getDashboardData() 
    {
        Map<String, Object> dashboardData = new HashMap<>();
        
        long totalEmployees = getTotalEmployees();
        dashboardData.put("totalEmployees", totalEmployees);

       
        BigDecimal averageSalary = getAverageSalary();
        dashboardData.put("averageSalary", averageSalary);
        
        BigDecimal totalPayouts = getTotalPayouts();
        dashboardData.put("totalPayouts", totalPayouts);

        BigDecimal totalDelayedPayouts = getTotalDelayedPayouts();
        dashboardData.put("totalDelayedPayouts", totalDelayedPayouts);
        
        Map<String, Long> employeesByDepartment = getEmployeesByDepartment();
        dashboardData.put("employeesByDepartment", employeesByDepartment);

        Map<String, BigDecimal> salaryByDepartment = getSalaryByDepartment();
        dashboardData.put("salaryByDepartment", salaryByDepartment);

        return dashboardData;
        }

    private long getTotalEmployees() 
    {
        return employeeRepository.count();
    }

    private BigDecimal getAverageSalary() 
    {
        return employeeSalaryRepository.findAverageBasicSalary();
    }

  
    public BigDecimal getTotalDelayedPayouts() 
    {
        BigDecimal delayedPayoutsTotal = employeeSalaryRepository.sumSalaryByIsDelayed(true);
        return delayedPayoutsTotal != null ? delayedPayoutsTotal : BigDecimal.ZERO;
    }
    
    
    public BigDecimal getTotalPayouts() 
    {
        BigDecimal totalPayouts = employeeSalaryRepository.sumTotalPayouts();
        return totalPayouts != null ? totalPayouts : BigDecimal.ZERO;
    }

    private Map<String, Long> getEmployeesByDepartment() 
    {
        List<Object[]> result = employeeRepository.findEmployeeCountByDepartment();
        Map<String, Long> employeesByDepartment = new HashMap<>();
        for (Object[] row : result) 
        {
            employeesByDepartment.put((String) row[0], (Long) row[1]);
        }
        return employeesByDepartment;
    }

    private Map<String, BigDecimal> getSalaryByDepartment() 
    {
        List<Object[]> result = employeeSalaryRepository.findAverageSalaryByDepartment();
        Map<String, BigDecimal> salaryByDepartment = new HashMap<>();
        for (Object[] row : result) {
            String department = (String) row[0];
            Double averageSalaryDouble = (Double) row[1];
            BigDecimal averageSalary = BigDecimal.valueOf(averageSalaryDouble);
            salaryByDepartment.put(department, averageSalary);
        }
        return salaryByDepartment;
    }
}