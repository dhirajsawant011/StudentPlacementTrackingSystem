package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.spts.model.Company;
import com.spts.services.CompanyService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewCompaniesServlet")
public class ViewCompaniesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        CompanyService service = new CompanyService();

        List<Company> list = service.getAllCompanies();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Companies</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");

        out.println("body{background:transparent;font-family:Arial;padding:10px;}");

        out.println(".table-box{background:white;padding:18px;border-radius:18px;}");

        out.println("h2{text-align:center;margin-bottom:18px;font-size:32px;}");

        out.println("table{font-size:15px;}");

        out.println("th{background:#f1f5f9;}");

        out.println(".btn{padding:5px 12px;font-size:13px;border-radius:8px;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='table-box'>");

        out.println("<h2>Companies List</h2>");

        out.println("<div class='table-responsive'>");

        out.println("<table class='table table-bordered table-hover align-middle'>");

        out.println("<tr>");

        out.println("<th>SR</th>");

        out.println("<th>Company</th>");

        out.println("<th>Package</th>");

        out.println("<th>Location</th>");

        out.println("<th>Criteria</th>");

        out.println("<th width='170'>Action</th>");

        out.println("</tr>");

        int count = 1;

        for(Company c : list)
        {
            out.println("<tr>");

            out.println("<td>" + count + "</td>");

            out.println("<td>" + c.getCompanyName() + "</td>");

            out.println("<td>" + c.getPackageName() + "</td>");

            out.println("<td>" + c.getLocation() + "</td>");

            out.println("<td>" + c.getCriteria() + "</td>");

            out.println("<td>");

            out.println("<a href='UpdateCompanyServlet?cid="
                    + c.getId()
                    + "' class='btn btn-warning me-2'>Update</a>");

            out.println("<a href='DeleteCompanyServlet?cid="
                    + c.getId()
                    + "' class='btn btn-danger'>Delete</a>");

            out.println("</td>");

            out.println("</tr>");

            count++;
        }

        out.println("</table>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}