package com.seclore.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seclore.main.domain.Employee;
import com.seclore.main.factory.ConnectionFactory;

public class EmployeeRepository implements EmployeeRepositoryInterface {

	private static final String INSERT_NEW_EMPLOYEE = "insert into employee_details(first_name,last_name,salary) values(?,?,?)";
	private static final String SELECT_ONE_EMPLOYEE = "select * from employee_details where employee_id=?";
	private static final String SELECT_ALL_EMPLOYEE = "select * from employee_details";
	private static final String UPDATE_EMPLOYEE_BY_EMPLOYEE_ID = "update employee_details set first_name=?,last_name=?,salary=? where employee_id=?";
	private static final String DELETE_EMPLOYEE_BY_EMPLOYEE_ID = "delete from employee_details where employee_id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	private int result;

	@Override
	public boolean addNewEmployee(Employee employee) {
		connection = ConnectionFactory.getConnection();
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
				preparedStatement.setString(1, employee.getFirstName());
				preparedStatement.setString(2, employee.getLastName());
				preparedStatement.setDouble(3, employee.getSalary());

				result = preparedStatement.executeUpdate();

				if (result > 0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int empId = resultSet.getInt("employee_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				double salary = resultSet.getDouble("salary");

				Employee employee = new Employee(empId, firstName, lastName, salary);

				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		connection = ConnectionFactory.getConnection();
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_EMPLOYEE_ID);
				preparedStatement.setString(1, employee.getFirstName());
				preparedStatement.setString(2, employee.getLastName());
				preparedStatement.setDouble(3, employee.getSalary());
				preparedStatement.setInt(4, employee.getEmployeeId());
				result = preparedStatement.executeUpdate();

				if (result > 0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		connection = ConnectionFactory.getConnection();
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_EMPLOYEE_ID);
				preparedStatement.setInt(1, employeeId);
				result = preparedStatement.executeUpdate();

				if (result > 0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList();
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("employee_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				double salary = resultSet.getDouble("salary");

				Employee employee = new Employee(employeeId, firstName, lastName, salary);

				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}
}
