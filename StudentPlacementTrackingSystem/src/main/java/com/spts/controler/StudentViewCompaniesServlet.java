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

@WebServlet("/StudentViewCompaniesServlet")
public class StudentViewCompaniesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        CompanyService service =
                new CompanyService();

        List<Company> list =
                service.getAllCompanies();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Companies</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");

        out.println("body{background:#f1f5f9;font-family:Arial;padding:20px;}");

        out.println(".card-box{display:flex;flex-wrap:wrap;gap:20px;justify-content:center;}");

        out.println(".company-card{width:300px;background:white;border-radius:15px;padding:20px;box-shadow:0px 3px 10px rgba(0,0,0,0.1);}");

        out.println(".company-card h3{color:#2563eb;}");

        out.println(".company-card p{margin:8px 0;font-size:15px;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card-box'>");

        for(Company c : list)
        {
            out.println("<div class='company-card'>");

            out.println("<h3>" +
                    c.getCompanyName() +
                    "</h3>");

            out.println("<p><b>Package :</b> "
                    + c.getPackageName() +
                    "</p>");

            out.println("<p><b>Location :</b> "
                    + c.getLocation() +
                    "</p>");

            out.println("<p><b>Criteria :</b> "
                    + c.getCriteria() +
                    "</p>");

            out.println("<a href='ApplyCompanyServlet?cid="
                    + c.getId()
                    + "' class='btn btn-primary w-100'>Apply Now</a>");

            out.println("</div>");
        }

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