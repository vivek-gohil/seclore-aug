package com.seclore.main.service;

import java.util.List;

import com.seclore.main.domain.Employee;

public interface EmployeeServiceInterface {
	boolean addNewEmployee(Employee employee);

	Employee getEmployeeByEmployeeId(int employeeId);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployeeByEmployeeId(int employeeId);
	
	List<Employee> getAllEmployees();
}
