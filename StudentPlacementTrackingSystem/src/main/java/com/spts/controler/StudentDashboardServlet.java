package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.spts.model.Dashboard;
import com.spts.model.Student;
import com.spts.services.PlacementService;
@WebServlet("/studentdashboard")
public class StudentDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        response.setHeader("Pragma", "no-cache");

        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("student") == null)
        {
            response.sendRedirect("StudentLogin.html");
            return;
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Student student =
                (Student) session.getAttribute("student");

        int sid = student.getSid();

        PlacementService service =
                new PlacementService();

        Dashboard dashboard =
                service.getDashboardData(sid);
        
        out.println("<html>");

        out.println("<head>");

        out.println("<title>Dashboard</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");

        out.println("body{background:#f1f5f9;padding:20px;font-family:Arial;}");

        out.println(".card-box{padding:25px;border-radius:15px;color:white;box-shadow:0px 4px 12px rgba(0,0,0,0.1);}");

        out.println(".bg1{background:#2563eb;}");

        out.println(".bg2{background:#059669;}");

        out.println(".bg3{background:#dc2626;}");

        out.println(".bg4{background:#7c3aed;}");

        out.println(".card-box h2{font-size:35px;font-weight:bold;}");

        out.println(".card-box h5{margin-top:10px;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container-fluid'>");

        out.println("<div class='row g-4'>");


        // TOTAL COMPANIES

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg1'>");

        out.println("<h2>"
        + dashboard.getTotalCompanies()
        + "</h2>");

        out.println("<h5>Total Companies</h5>");

        out.println("</div>");

        out.println("</div>");


        // APPLIED

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg2'>");

        out.println("<h2>"
        + dashboard.getAppliedCompanies()
        + "</h2>");

        out.println("<h6>Applied Companies</h6>");

        out.println("</div>");

        out.println("</div>");


        // SELECTED

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg3'>");

        out.println("<h2>"
        + dashboard.getSelectedCompanies()
        + "</h2>");

        out.println("<h5>Selected</h5>");

        out.println("</div>");

        out.println("</div>");


        // REJECTED

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg4'>");

        out.println("<h2>"
        + dashboard.getRejectedCompanies()
        + "</h2>");

        out.println("<h5>Rejected</h5>");

        out.println("</div>");

        out.println("</div>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");

    }
}