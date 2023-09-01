package com.seclore.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Employee;

@Component
public class EmployeeRepository implements EmployeeRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String ADD_NEW_EMPLOYEE = "insert into employee_details(first_name,last_name,salary) values(?,?,?)";
	private static final String SELECT_ALL_EMPLOYEE = "select * from employee_details";
	private static final String SELECT_ONE_EMPLOYEE = "select * from employee_details where employee_id=?";
	private static final String DELETE_ONE_EMPLOYEE = "delete from employee_details where employee_id=?";
	private static final String UPDATE_EMPLOYEE = "update employee_details set first_name=?,last_name=?,salary=? where employee_id=?";

	public boolean addNewEmployee(Employee employee) {
		Object[] args = { employee.getFirstName(), employee.getLastName(), employee.getSalary() };
		int count = jdbcTemplate.update(ADD_NEW_EMPLOYEE, args);
		if (count > 0)
			return true;
		return false;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = jdbcTemplate.query(SELECT_ALL_EMPLOYEE, new EmployeeRowMapper());
		return employeeList;
	}

	public Employee getSingleEmployee(int employeeId) {
		Employee employee = jdbcTemplate.queryForObject(SELECT_ONE_EMPLOYEE, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	public boolean removeEmployee(int employeeId) {
		int count = jdbcTemplate.update(DELETE_ONE_EMPLOYEE, employeeId);
		if (count > 0)
			return true;
		return false;
	}

	public boolean updateEmployee(Employee employee) {
		Object[] args = { employee.getFirstName(), employee.getLastName(), employee.getSalary(),
				employee.getEmployeeId() };
		int count = jdbcTemplate.update(UPDATE_EMPLOYEE, args);
		if (count > 0)
			return true;
		return false;
	}

}
