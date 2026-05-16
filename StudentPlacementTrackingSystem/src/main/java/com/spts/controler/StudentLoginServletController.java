package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServletController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt = conn.prepareStatement(
                    "select * from students where email=? and password=?");

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                HttpSession session = request.getSession();

                com.spts.model.Student student =
                        new com.spts.model.Student();

                student.setSid(rs.getInt("sid"));

                student.setName(rs.getString("name"));

                student.setEmail(rs.getString("email"));

                student.setMobile(rs.getString("mobile"));

                student.setCourse(rs.getString("course"));

                student.setPercentage(rs.getDouble("percentage"));

                student.setSkills(rs.getString("skills"));

                student.setPassword(rs.getString("password"));

                session.setAttribute("student", student);

                response.sendRedirect("student.html");
   

            } else {

                out.println("<h2>Invalid Username or Password</h2>");
            }

        } catch (Exception e) {

            out.println(e);
        }
    }
}