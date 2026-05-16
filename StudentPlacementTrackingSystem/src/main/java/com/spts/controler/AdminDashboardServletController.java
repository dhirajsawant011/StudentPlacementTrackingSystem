package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admindashboard")
public class AdminDashboardServletController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Prevent Browser Cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        // Check Session
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("admin") == null) {

            response.sendRedirect("Login.html");
            return;
        }
        
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Open Admin Page
        request.getRequestDispatcher("admin.html").forward(request, response);
    }
    
}