package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StudentNameServlet")
public class StudentNameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        HttpSession session =
                request.getSession();

        Student student =
                (Student) session.getAttribute("student");

        if(student != null)
        {
            out.print(student.getName());
        }
    }
}