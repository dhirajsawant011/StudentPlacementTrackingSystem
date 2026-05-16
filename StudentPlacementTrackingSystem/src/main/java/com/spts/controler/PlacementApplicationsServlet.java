package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import com.spts.model.Placement;
import com.spts.services.PlacementService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlacementApplicationsServlet")
public class PlacementApplicationsServlet
extends HttpServlet
{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();

        PlacementService service =
                new PlacementService();

        ResultSet rs = service.getAllApplications();
        out.println("<html>");

        out.println("<head>");

        out.println("<title>Placement Applications</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");

        out.println("body{background:#eef2f7;font-family:Arial;padding:20px;}");

        out.println(".card-box{background:white;padding:25px;border-radius:15px;box-shadow:0px 4px 12px rgba(0,0,0,0.10);}");

        out.println("h2{text-align:center;margin-bottom:25px;font-size:32px;}");

        out.println(".table th{text-align:center;background:#2563eb;color:white;}");

        out.println(".table td{text-align:center;vertical-align:middle;}");

        out.println(".btn{padding:5px 12px;font-size:14px;border-radius:8px;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card-box'>");

        out.println("<h2>Placement Applications</h2>");

        out.println("<div class='table-responsive'>");

        out.println("<table class='table table-bordered table-hover'>");

        out.println("<tr>");

        out.println("<th>SR NO</th>");

        out.println("<th>Student Name</th>");

        out.println("<th>Company Name</th>");

        out.println("<th>Apply Date</th>");

        out.println("<th>Status</th>");

        out.println("<th>Action</th>");

        out.println("</tr>");

        int count = 1;
        try
        {

            while(rs.next())
            {

                out.println("<tr>");

                out.println("<td>"+count+"</td>");

                out.println("<td>"+rs.getString("name")+"</td>");

                out.println("<td>"+rs.getString("company_name")+"</td>");

                out.println("<td>"+rs.getString("apply_date")+"</td>");

                out.println("<td>");

                if(rs.getString("status").equals("Placed"))
                {
                    out.println("<span class='badge bg-success'>Placed</span>");
                }
                else if(rs.getString("status").equals("Rejected"))
                {
                    out.println("<span class='badge bg-danger'>Rejected</span>");
                }
                else
                {
                    out.println("<span class='badge bg-warning text-dark'>Applied</span>");
                }

                out.println("</td>");

                out.println("<td>");

                out.println("<a href='UpdatePlacementStatusServlet?pid="
                        +rs.getInt("pid")
                        +"&status=Placed' class='btn btn-success btn-sm me-2'>Placed</a>");

                out.println("<a href='UpdatePlacementStatusServlet?pid="
                        +rs.getInt("pid")
                        +"&status=Rejected' class='btn btn-danger btn-sm'>Rejected</a>");

                out.println("</td>");

                out.println("</tr>");

                count++;
            }

        }
        catch(Exception e)
        {
            out.println(e);
        }

        out.println("</table>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {

        doGet(request,response);
    }
}