package com.seclore.main.service;

import java.util.List;

import com.seclore.main.domain.Employee;

public interface EmployeeServiceInterface {
	public boolean addNewEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getSingleEmployee(int employeeId);

	public boolean removeEmployee(int employeeId);

	public boolean updateEmployee(Employee employee);
}
