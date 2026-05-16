package com.spts.controler;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.model.Company;
import com.spts.services.CompanyService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCompanyServlet")
public class UpdateCompanyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int cid = Integer.parseInt(request.getParameter("cid"));

		CompanyService service = new CompanyService();

		Company c = service.getCompanyById(cid);

		out.println("<html>");

		out.println("<head>");

		out.println(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='container mt-5'>");

		out.println("<div class='col-md-5 mx-auto'>");

		out.println("<div class='card p-4 shadow'>");

		out.println("<h2 class='text-center'>Update Company</h2>");

		out.println("<form action='UpdateCompanyServlet' method='post'>");

		out.println("<input type='hidden' name='cid' value='" + c.getId() + "'>");

		out.println("<div class='mb-3'>");

		out.println("<input type='text' name='companyName' class='form-control' value='" + c.getCompanyName() + "'>");

		out.println("</div>");

		out.println("<div class='mb-3'>");

		out.println("<input type='text' name='packageName' class='form-control' value='" + c.getPackageName() + "'>");

		out.println("</div>");

		out.println("<div class='mb-3'>");

		out.println("<input type='text' name='location' class='form-control' value='" + c.getLocation() + "'>");

		out.println("</div>");

		out.println("<div class='mb-3'>");

		out.println("<input type='text' name='criteria' class='form-control' value='" + c.getCriteria() + "'>");

		out.println("</div>");

		out.println("<div class='mb-3'>");

		out.println("<input type='submit' value='Update Company' class='btn btn-success w-100'>");

		out.println("</div>");

		out.println("</form>");

		out.println("</div>");

		out.println("</div>");

		out.println("</div>");

		out.println("</body>");

		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cid = Integer.parseInt(request.getParameter("cid"));

		String companyName = request.getParameter("companyName");

		String packageName = request.getParameter("packageName");

		String location = request.getParameter("location");

		String criteria = request.getParameter("criteria");

		Company company = new Company();

		company.setId(cid);

		company.setCompanyName(companyName);

		company.setPackageName(packageName);

		company.setLocation(location);

		company.setCriteria(criteria);

		CompanyService service = new CompanyService();

		boolean status = service.updateCompany(company);

		if (status) {
			response.sendRedirect("ViewCompaniesServlet");
		} else {
			response.getWriter().println("<h2>Company Not Updated</h2>");
		}
	}

}
