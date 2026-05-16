package com.spts.controler;

import java.io.IOException;

import com.spts.services.PlacementService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePlacementStatusServlet")
public class UpdatePlacementStatusServlet
extends HttpServlet
{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {

        int pid =
                Integer.parseInt(
                request.getParameter("pid"));

        String status =
                request.getParameter("status");

        PlacementService service =
                new PlacementService();

        service.updateStatus(pid,status);

        response.sendRedirect(
                "PlacementApplicationsServlet");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {

        doGet(request,response);
    }
}