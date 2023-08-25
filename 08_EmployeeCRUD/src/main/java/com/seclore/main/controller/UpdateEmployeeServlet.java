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
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private EmployeeServiceInterface employeeService = new EmployeeService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId;
		String firstName, lastName;
		double salary;
		employeeId = Integer.parseInt(request.getParameter("employeeid"));
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		salary = Double.parseDouble(request.getParameter("salary"));

		Employee employee = new Employee(employeeId, firstName, lastName, salary);

		System.out.println(employee);

		boolean result = employeeService.updateEmployee(employee);
		if (result)
			response.sendRedirect("allemployees.jsp");
		else
			response.sendRedirect("failure.html");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
		if (employee != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("employee", employee);
			response.sendRedirect("updateemployee.jsp");
		} else {
			response.sendRedirect("failure.html");
		}

	}

}
