package com.seclore.main.repository;

import java.util.List;

import com.seclore.main.domain.Employee;

public interface EmployeeRepositoryInterface {
	boolean addNewEmployee(Employee employee);

	Employee getEmployeeByEmployeeId(int employeeId);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployeeByEmployeeId(int employeeId);

	List<Employee> getAllEmployees();
}
