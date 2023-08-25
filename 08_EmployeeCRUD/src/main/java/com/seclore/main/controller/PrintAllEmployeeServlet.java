package com.seclore.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.seclore.main.domain.Employee;
import com.seclore.main.service.EmployeeService;
import com.seclore.main.service.EmployeeServiceInterface;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PrintAllEmployeeServlet")
public class PrintAllEmployeeServlet extends HttpServlet {
	private EmployeeServiceInterface employeeService = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employeeList = employeeService.getAllEmployees();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<table border=1>");
		out.println("<tr><td>Employee Id</td><td>First Name</td><td>Last Name</td><td>Salary</td></tr>");
		for (Employee employee : employeeList) {
			out.println("<tr>");
			out.println("<td>");
			out.println(employee.getEmployeeId());
			out.println("</td>");
			out.println("<td>");
			out.println(employee.getFirstName());
			out.println("</td>");
			out.println("<td>");
			out.println(employee.getLastName());
			out.println("</td>");
			out.println("<td>");
			out.println(employee.getSalary());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}
