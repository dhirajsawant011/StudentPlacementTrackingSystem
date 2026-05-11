package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String course = request.getParameter("course");
		String percentage = request.getParameter("percentage");
		String skills = request.getParameter("skills");
		String password = request.getParameter("password");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/placement_tracking_system",
					"root",
					"8010865586");

			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO students(name,email,mobile,course,percentage,skills,password) VALUES(?,?,?,?,?,?,?)");

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, mobile);
			pstmt.setString(4, course);
			pstmt.setString(5, percentage);
			pstmt.setString(6, skills);
			pstmt.setString(7, password);

			int i = pstmt.executeUpdate();

			if (i > 0) {

				out.println("<h2>Registration Successful</h2>");

			} else {

				out.println("<h2>Registration Failed</h2>");
			}

			conn.close();

		} catch (Exception e) {

			out.println(e);
		}
	}
}