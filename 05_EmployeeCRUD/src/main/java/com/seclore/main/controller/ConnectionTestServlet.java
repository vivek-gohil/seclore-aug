package com.seclore.main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/secloredb";
		String user = "root";
		String password = "root";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("connection successful");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("connection failed!");
			System.out.println(e.getMessage());
		}
	}

}
