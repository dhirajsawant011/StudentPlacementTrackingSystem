package com.spts.controler;

import java.io.IOException;
import java.time.LocalDate;

import com.spts.model.Student;
import com.spts.services.PlacementService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ApplyCompanyServlet")
public class ApplyCompanyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int cid =
                Integer.parseInt(request.getParameter("cid"));

        HttpSession session =
                request.getSession();

        Student student =
                (Student) session.getAttribute("student");

        int sid = student.getSid();

        PlacementService service =
                new PlacementService();

        boolean status =
                service.applyCompany(
                        sid,
                        cid,
                        LocalDate.now().toString());

        if(status)
        {
            response.sendRedirect("AppliedCompaniesServlet");
        }
        else
        {
            response.getWriter().println(
                    "<h2>Application Failed</h2>");
        }
    }
}