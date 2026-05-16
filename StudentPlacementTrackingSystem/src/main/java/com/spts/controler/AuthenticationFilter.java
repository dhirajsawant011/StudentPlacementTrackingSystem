package com.spts.controler;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin.html")
public class AuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse res,
                            FilterChain chain)
            throws IOException, ServletException {

        // Prevent Cache
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setDateHeader("Expires", 0);

        HttpSession session = req.getSession(false);

        // Check Login
        if (session == null || session.getAttribute("admin") == null) {

            res.sendRedirect("Login.html");
            return;
        }

        chain.doFilter(req, res);
    }
}