package com.seclore.main.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee {
	private int employeeId;
	@Size(min = 2, max = 15)
	private String firstName;
	@Size(min = 2, max = 15)
	private String lastName;
	@Min(value = 0)
	private double salary;

	public Employee() {
		System.out.println("Employee object created");
	}

	public Employee(int employeeId, String firstName, String lastName, double salary) {
		System.out.println("oberloaded constrcutor");
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int getEmployeeId() {
		System.out.println("getEmployeeId");
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		System.out.println("setEmployeeId");
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		System.out.println("getFirstName");
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("setFirstName");
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println("getLastName");
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println("setLastName");
		this.lastName = lastName;
	}

	public double getSalary() {
		System.out.println("getSalary");
		return salary;
	}

	public void setSalary(double salary) {
		System.out.println("setSalary");
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + "]";
	}

}
