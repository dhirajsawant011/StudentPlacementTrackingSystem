package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.model.Student;
import com.spts.services.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateStudentProfileServlet")
public class UpdateStudentProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Student loginStudent =
                (Student) session.getAttribute("student");

        int sid = loginStudent.getSid();

        StudentService service = new StudentService();

        Student s = service.getStudentById(sid);

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Update Profile</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("</head>");

        out.println("<body style='background:#f1f5f9;'>");

        out.println("<div class='container mt-4'>");

        out.println("<div class='col-md-6 mx-auto'>");

        out.println("<div class='card shadow p-4'>");

        out.println("<h3 class='text-center mb-4'>Update Profile</h3>");

        out.println("<form action='UpdateStudentProfileServlet' method='post'>");

        out.println("<input type='hidden' name='sid' value='" + s.getSid() + "'>");

        out.println("<div class='mb-3'>");
        out.println("<input type='text' name='name' class='form-control' value='" + s.getName() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='email' name='email' class='form-control' value='" + s.getEmail() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='text' name='mobile' class='form-control' value='" + s.getMobile() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='text' name='course' class='form-control' value='" + s.getCourse() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='text' name='percentage' class='form-control' value='" + s.getPercentage() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='text' name='skills' class='form-control' value='" + s.getSkills() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='password' name='password' class='form-control' value='" + s.getPassword() + "'>");
        out.println("</div>");

        out.println("<div class='text-center'>");

        out.println("<input type='submit' value='Update Profile' class='btn btn-primary px-4'>");

        out.println("</div>");

        out.println("</form>");

        out.println("</div>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int sid =
                Integer.parseInt(request.getParameter("sid"));

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String mobile = request.getParameter("mobile");

        String course = request.getParameter("course");

        double percentage =
                Double.parseDouble(
                        request.getParameter("percentage"));

        String skills = request.getParameter("skills");

        String password = request.getParameter("password");

        Student student = new Student();

        student.setSid(sid);

        student.setName(name);

        student.setEmail(email);

        student.setMobile(mobile);

        student.setCourse(course);

        student.setPercentage(percentage);

        student.setSkills(skills);

        student.setPassword(password);

        StudentService service =
                new StudentService();

        boolean status =
                service.updateStudentProfile(student);

        if(status)
        {
            HttpSession session =
                    request.getSession();

            session.setAttribute("student", student);

            response.sendRedirect("StudentProfileServlet");
        }
        else
        {
            response.getWriter().println(
                    "<h2>Profile Not Updated</h2>");
        }
    }
}