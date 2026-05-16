package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.spts.model.Student;
import com.spts.services.PlacementService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;@WebServlet("/AppliedCompaniesServlet")
public class AppliedCompaniesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session =
                request.getSession();

        Student student =
                (Student) session.getAttribute("student");

        int sid = student.getSid();

        PlacementService service =
                new PlacementService();

        ResultSet rs =
                service.getAppliedCompanies(sid);

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Applied Companies</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");

        out.println("body{background:#f1f5f9;padding:20px;font-family:Arial;}");

        out.println(".table-box{background:white;padding:20px;border-radius:15px;box-shadow:0px 3px 10px rgba(0,0,0,0.1);}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='table-box'>");

        out.println("<h2 class='mb-4 text-center'>Applied Companies</h2>");

        out.println("<table class='table table-bordered table-hover'>");

        out.println("<tr class='table-dark'>");

        out.println("<th>SR NO</th>");

        out.println("<th>Company</th>");

        out.println("<th>Package</th>");

        out.println("<th>Location</th>");

        out.println("<th>Apply Date</th>");

        out.println("<th>Status</th>");

        out.println("</tr>");

        int count = 1;
        
        try {
        while(rs.next())
        {
            out.println("<tr>");

            out.println("<td>" + count + "</td>");

            out.println("<td>"
                    + rs.getString("company_name")
                    + "</td>");

            out.println("<td>"
                    + rs.getString("package")
                    + "</td>");

            out.println("<td>"
                    + rs.getString("location")
                    + "</td>");

            out.println("<td>"
                    + rs.getString("apply_date")
                    + "</td>");

            out.println("<td>"
                    + rs.getString("status")
                    + "</td>");

            out.println("</tr>");

            count++;
        }
        }catch(Exception ex)
        {
        	out.println("error is " + ex);
        }

        out.println("</table>");

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