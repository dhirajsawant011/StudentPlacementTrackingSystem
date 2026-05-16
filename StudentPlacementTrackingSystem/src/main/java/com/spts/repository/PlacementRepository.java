package com.spts.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.spts.model.Dashboard;
import com.spts.model.Placement;
import java.util.*;

public class PlacementRepository implements PlacementRepositoryInterface {

    public boolean applyCompany(int sid,
                                int cid,
                                String applyDate)
    {
        boolean status = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                    DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt =
                    conn.prepareStatement(
                    "insert into placements(sid,cid,apply_date,status) values(?,?,?,?)");

            pstmt.setInt(1, sid);

            pstmt.setInt(2, cid);

            pstmt.setString(3, applyDate);

            pstmt.setString(4, "Applied");

            int rows = pstmt.executeUpdate();

            if(rows > 0)
            {
                status = true;
            }

            pstmt.close();

            conn.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return status;
    }
    
    public ResultSet getAppliedCompanies(int sid)
    {
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                    DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt =
                    conn.prepareStatement(
                    "select p.pid, c.company_name, c.package, c.location, p.apply_date, p.status from placements p inner join companies c on p.cid=c.cid where p.sid=?");

            pstmt.setInt(1, sid);

            rs = pstmt.executeQuery();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return rs;
    }
    
    public Dashboard getDashboardData(int sid)
    {
        Dashboard dashboard =
                new Dashboard();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                    DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            // TOTAL COMPANIES

            PreparedStatement pstmt1 =
                    conn.prepareStatement(
                    "select count(*) from companies");

            ResultSet rs1 =
                    pstmt1.executeQuery();

            if(rs1.next())
            {
                dashboard.setTotalCompanies(
                        rs1.getInt(1));
            }

            // APPLIED

            PreparedStatement pstmt2 =
                    conn.prepareStatement(
                    "select count(*) from placements where sid=?");

            pstmt2.setInt(1, sid);

            ResultSet rs2 =
                    pstmt2.executeQuery();

            if(rs2.next())
            {
                dashboard.setAppliedCompanies(
                        rs2.getInt(1));
            }

            // SELECTED

            PreparedStatement pstmt3 =
                    conn.prepareStatement(
                    "select count(*) from placements where sid=? and status='Selected'");

            pstmt3.setInt(1, sid);

            ResultSet rs3 =
                    pstmt3.executeQuery();

            if(rs3.next())
            {
                dashboard.setSelectedCompanies(
                        rs3.getInt(1));
            }

            // REJECTED

            PreparedStatement pstmt4 =
                    conn.prepareStatement(
                    "select count(*) from placements where sid=? and status='Rejected'");

            pstmt4.setInt(1, sid);

            ResultSet rs4 =
                    pstmt4.executeQuery();

            if(rs4.next())
            {
                dashboard.setRejectedCompanies(
                        rs4.getInt(1));
            }

            conn.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return dashboard;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // ADMIN VIEW ALL APPLICATIONS

    public ResultSet getAllApplications()
    {

        ResultSet rs = null;

        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                    DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement ps =
                    conn.prepareStatement(

            "select p.pid, s.name, c.company_name, p.apply_date, p.status " +
            "from placements p " +
            "join students s on p.sid = s.sid " +
            "join companies c on p.cid = c.cid"

                    );

            rs = ps.executeQuery();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return rs;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // UPDATE STATUS

    public boolean updateStatus(int pid,String status)
    {

        boolean result = false;

        try
        {

        	 Class.forName("com.mysql.cj.jdbc.Driver");

             Connection conn =
                     DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/placement_tracking_system",
                     "root",
                     "Dhiraj@1432");

            PreparedStatement ps =
                    conn.prepareStatement(

            "update placements set status=? where pid=?"

                    );

            ps.setString(1, status);

            ps.setInt(2, pid);

            int rows =
                    ps.executeUpdate();

            if(rows > 0)
            {
                result = true;
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }
    
    
    //Total companies count
    public int getTotalCompanies()
    {
        int count = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/placement_tracking_system",
            "root",
            "Dhiraj@1432");

            PreparedStatement ps =
            conn.prepareStatement(
            "select count(*) from companies");

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                count = rs.getInt(1);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return count;
    }
    
    
    //TOTAL STUDENTS
    
    public int getTotalStudents()
    {
        int count = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/placement_tracking_system",
            "root",
            "Dhiraj@1432");

            PreparedStatement ps =
            conn.prepareStatement(
            "select count(*) from students");

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                count = rs.getInt(1);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return count;
    }
    
    
    //PLACED COUNT
    public int getPlacedCount()
    {
        int count = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/placement_tracking_system",
            "root",
            "Dhiraj@1432");

            PreparedStatement ps =
            conn.prepareStatement(
            "select count(*) from placements where status='Placed'");

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                count = rs.getInt(1);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return count;
    }
    
    //REJECTED COUNT
    public int getRejectedCount()
    {
        int count = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/placement_tracking_system",
            "root",
            "Dhiraj@1432");

            PreparedStatement ps =
            conn.prepareStatement(
            "select count(*) from placements where status='Rejected'");

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                count = rs.getInt(1);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return count;
    }
    
    
    
}