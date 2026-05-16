package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.services.PlacementService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        PlacementService service =
                new PlacementService();

        int companies =
                service.getTotalCompanies();

        int students =
                service.getTotalStudents();

        int placed =
                service.getPlacedCount();

        int rejected =
                service.getRejectedCount();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Admin Dashboard</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");

        out.println("body{background:#eef2f7;padding:20px;font-family:Arial;}");

        out.println(".card-box{padding:25px;border-radius:15px;color:white;text-align:center;box-shadow:0px 4px 12px rgba(0,0,0,0.1);}");

        out.println(".card-box h1{font-size:45px;font-weight:bold;}");

        out.println(".card-box h4{margin-top:10px;}");

        out.println(".bg1{background:#2563eb;}");

        out.println(".bg2{background:#059669;}");

        out.println(".bg3{background:#7c3aed;}");

        out.println(".bg4{background:#dc2626;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container mt-4'>");

        out.println("<div class='row g-4'>");

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg1'>");

        out.println("<h1>"+companies+"</h1>");

        out.println("<h4>Total Companies</h4>");

        out.println("</div>");

        out.println("</div>");

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg2'>");

        out.println("<h1>"+students+"</h1>");

        out.println("<h4>Total Students view</h4>");

        out.println("</div>");

        out.println("</div>");

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg3'>");

        out.println("<h1>"+placed+"</h1>");

        out.println("<h4>Placed Students</h4>");

        out.println("</div>");

        out.println("</div>");

        out.println("<div class='col-md-3'>");

        out.println("<div class='card-box bg4'>");

        out.println("<h1>"+rejected+"</h1>");

        out.println("<h4>Rejected Students</h4>");

        out.println("</div>");

        out.println("</div>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request,response);
    }
}