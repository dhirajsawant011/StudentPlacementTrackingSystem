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

@WebServlet("/StudentProfileServlet")
public class StudentProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Student loginStudent = (Student) session.getAttribute("student");
        
        int sid = loginStudent.getSid();

        StudentService service = new StudentService();

        Student s = service.getStudentById(sid);
       

        out.println("<html>");

        out.println("<head>");

        out.println("<title>My Profile</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");

        out.println("body{");
        out.println("background:#f1f5f9;");
        out.println("font-family:Arial;");
        out.println("margin:0;");
        out.println("padding:0;");
        out.println("overflow:hidden;");
        out.println("}");

        out.println(".profile-card{");
        out.println("width:60%;");
        out.println("margin:auto;");
        out.println("margin-top:10px;");
        out.println("background:white;");
        out.println("padding:15px;");
        out.println("border-radius:12px;");
        out.println("box-shadow:0px 3px 10px rgba(0,0,0,0.1);");
        out.println("}");

        out.println(".profile-img{");
        out.println("text-align:center;");
        out.println("}");

        out.println(".profile-img img{");
        out.println("width:55px;");
        out.println("height:55px;");
        out.println("border-radius:50%;");
        out.println("border:2px solid #2563eb;");
        out.println("}");

        out.println(".profile-title{");
        out.println("text-align:center;");
        out.println("font-size:20px;");
        out.println("font-weight:bold;");
        out.println("margin-top:5px;");
        out.println("margin-bottom:10px;");
        out.println("}");

        out.println(".info-box{");
        out.println("background:#f8fafc;");
        out.println("padding:10px 15px;");
        out.println("border-radius:8px;");
        out.println("margin-bottom:10px;");
        out.println("font-size:15px;");
        out.println("}");

        out.println(".info-box b{");
        out.println("color:#2563eb;");
        out.println("}");

        out.println(".btn-box{");
        out.println("text-align:center;");
        out.println("margin-top:10px;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='profile-card'>");

        out.println("<div class='profile-img'>");

        out.println("<img src='https://cdn-icons-png.flaticon.com/512/3135/3135715.png'>");

        out.println("</div>");

        out.println("<div class='profile-title'>My Profile</div>");

        out.println("<div class='info-box'>");
        out.println("<b>Name :</b> " + s.getName());
        out.println("</div>");

        out.println("<div class='info-box'>");
        out.println("<b>Email :</b> " + s.getEmail());
        out.println("</div>");

        out.println("<div class='info-box'>");
        out.println("<b>Mobile :</b> " + s.getMobile());
        out.println("</div>");

        out.println("<div class='info-box'>");
        out.println("<b>Course :</b> " + s.getCourse());
        out.println("</div>");

        out.println("<div class='info-box'>");
        out.println("<b>Percentage :</b> " + s.getPercentage());
        out.println("</div>");

        out.println("<div class='info-box'>");
        out.println("<b>Skills :</b> " + s.getSkills());
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