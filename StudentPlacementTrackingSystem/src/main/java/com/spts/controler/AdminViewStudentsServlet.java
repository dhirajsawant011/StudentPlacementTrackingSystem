package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import com.spts.model.Student;
import com.spts.services.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminViewStudentsServlet")
public class AdminViewStudentsServlet
extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StudentService service =
                new StudentService();

        List<Student> list =
                service.getAllStudents();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>View Students</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container mt-5'>");

        out.println("<h2 class='text-center mb-4'>Students List</h2>");

        out.println("<table class='table table-bordered table-striped'>");

        out.println("<tr>");

        out.println("<th>SR NO</th>");

        out.println("<th>Name</th>");

        out.println("<th>Email</th>");

        out.println("<th>Mobile</th>");

        out.println("<th>Course</th>");

        out.println("<th>Percentage</th>");

        out.println("<th>Skills</th>");

        out.println("</tr>");

        int count = 1;

        for(Student s : list)
        {
            out.println("<tr>");

            out.println("<td>" + count + "</td>");

            out.println("<td>" + s.getName() + "</td>");

            out.println("<td>" + s.getEmail() + "</td>");

            out.println("<td>" + s.getMobile() + "</td>");

            out.println("<td>" + s.getCourse() + "</td>");

            out.println("<td>" + s.getPercentage() + "</td>");

            out.println("<td>" + s.getSkills() + "</td>");

            out.println("</tr>");

            count++;
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