package com.spts.controler;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/student.html")
public class StudentAuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain)
            throws IOException, ServletException {

        // Prevent Cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        response.setHeader("Pragma", "no-cache");

        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("student") == null)
        {
            response.sendRedirect("studentlogin.html");
            return;
        }

        chain.doFilter(request, response);
    }
}