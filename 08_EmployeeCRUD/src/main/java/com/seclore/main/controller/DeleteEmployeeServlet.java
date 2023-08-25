package com.seclore.main.controller;

import java.io.IOException;

import com.seclore.main.service.EmployeeService;
import com.seclore.main.service.EmployeeServiceInterface;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeServiceInterface employeeServiceInterface = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		boolean result = employeeServiceInterface.deleteEmployeeByEmployeeId(employeeId);
		if (result) {
			response.sendRedirect("allemployees.jsp");
		} else
			response.sendRedirect("failure.html");
	}

}
