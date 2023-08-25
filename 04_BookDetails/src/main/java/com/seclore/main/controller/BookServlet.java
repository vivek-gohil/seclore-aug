package com.seclore.main.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		int maxFileSize = Integer.valueOf(context.getInitParameter("maxfileuploadsize"));
		String message = config.getInitParameter("message");
		out.println("Context :: " + maxFileSize);
		out.println("Config :: " + message);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();

		List<String> books = new ArrayList<>();
		if (context.getAttribute("books") != null) {
			books = (List<String>) context.getAttribute("books");
		} else {
			context.setAttribute("books", books);
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (request.getParameter("bookname") != null) {
			String newBook = request.getParameter("bookname");
			books.add(newBook);
			context.setAttribute("books", books);
		}
		out.println("<h3>All Books</h3>");
		for (String book : books) {
			out.println("<h3>" + book + "</h3>");
		}
		out.println("<a href=index.html>Back</a>");
	}

}
