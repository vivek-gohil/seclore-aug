package com.seclore.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Employee;
import com.seclore.main.repository.EmployeeRepositoryInterface;

@Component
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepositoryInterface employeeRepository;

	public boolean addNewEmployee(Employee employee) {
		return employeeRepository.addNewEmployee(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

	public Employee getSingleEmployee(int employeeId) {
		return employeeRepository.getSingleEmployee(employeeId);
	}

	public boolean removeEmployee(int employeeId) {
		return employeeRepository.removeEmployee(employeeId);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

}
