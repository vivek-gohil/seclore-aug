package com.seclore.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId = request.getParameter("loginid");
		String password = request.getParameter("password");
		
		ServletContext context = getServletContext();
		context.setAttribute(password, context);

		RequestDispatcher dispatcher = null;
		if (loginId.equals("admin") && password.equals("admin@123")) {
			 dispatcher = request.getRequestDispatcher("welcome.html");
		} else {
			 dispatcher = request.getRequestDispatcher("failure.html");
		}
		dispatcher.forward(request, response);
		
	}

}
