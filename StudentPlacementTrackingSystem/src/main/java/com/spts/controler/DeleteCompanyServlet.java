package com.spts.controler;

import java.io.IOException;

import com.spts.services.CompanyService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCompanyServlet")
public class DeleteCompanyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int cid =
                Integer.parseInt(
                request.getParameter("cid"));

        CompanyService service =
                new CompanyService();

        boolean status =
                service.deleteCompany(cid);

        if(status)
        {
            response.sendRedirect(
                    "ViewCompaniesServlet");
        }
        else
        {
            response.getWriter()
            .println("<h2>Company Not Deleted</h2>");
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}