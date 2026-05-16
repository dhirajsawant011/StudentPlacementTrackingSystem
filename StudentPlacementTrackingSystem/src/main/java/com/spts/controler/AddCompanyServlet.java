package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.model.Company;
import com.spts.services.CompanyService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddCompanyServlet")
public class AddCompanyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String companyName = request.getParameter("companyName");
        String packageName = request.getParameter("packageName");
        String location = request.getParameter("location");
        String criteria = request.getParameter("criteria");

        Company company = new Company(
                companyName,
                packageName,
                location,
                criteria);

        CompanyService service = new CompanyService();

        boolean status = service.addCompany(company);

        if(status)
        {
            out.println("<html>");

            out.println("<body style='text-align:center;margin-top:100px;'>");

            out.println("<h2 style='color:green;'>Company Added Successfully</h2>");

            out.println("<br>");

            out.println("</body>");

            out.println("</html>");
        }
        else
        {
            out.println("<h2>Company Not Added</h2>");
        }
    }
}