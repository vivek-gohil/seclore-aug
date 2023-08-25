package com.seclore.main.controller;

import java.io.IOException;

import com.seclore.main.domain.Employee;
import com.seclore.main.service.EmployeeService;
import com.seclore.main.service.EmployeeServiceInterface;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddNewEmployeeServlet")
public class AddNewEmployeeServlet extends HttpServlet {

	private EmployeeServiceInterface employeeService = new EmployeeService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName, lastName;
		double salary;

		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		salary = Double.parseDouble(request.getParameter("salary"));

		Employee employee = new Employee(firstName, lastName, salary);

		System.out.println(employee);

		boolean result = employeeService.addNewEmployee(employee);
		if (result)
			response.sendRedirect("allemployees.jsp");
		else
			response.sendRedirect("failure.html");
	}

}
