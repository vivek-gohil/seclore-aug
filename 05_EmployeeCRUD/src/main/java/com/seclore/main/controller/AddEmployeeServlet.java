package com.seclore.main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName,lastName;
		double salary;
		firstName = request.getParameter("txtfirstname");
		lastName = request.getParameter("txtlastname");
		salary = Double.parseDouble(request.getParameter("txtsalary"));
		
		String url = "jdbc:mysql://localhost:3306/secloredb";
		String user = "root";
		String password = "root";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("connection successful");
				String query = "insert into employee_details(first_name,last_name,salary) values(?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2,lastName);
				preparedStatement.setDouble(3, salary);
				
				int resultCount = preparedStatement.executeUpdate();
				if(resultCount > 0) {
					System.out.println("inserted successfully");
					System.out.println("check your database");
				}
				else {
					System.out.println("failed to insert");
				}
		
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("connection failed!");
			System.out.println(e.getMessage());
		}
		
		
	}

}
