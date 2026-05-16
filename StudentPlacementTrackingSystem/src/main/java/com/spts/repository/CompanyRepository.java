package com.spts.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.spts.model.Company;
import java.sql.*;
import java.util.*;
public class CompanyRepository implements CompanyRepositoryInterface {

    public boolean addCompany(Company company) {

        boolean status = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt = conn.prepareStatement(
                    "insert into companies(company_name, package, location, criteria) values(?,?,?,?)");

            pstmt.setString(1, company.getCompanyName());
            pstmt.setString(2, company.getPackageName());
            pstmt.setString(3, company.getLocation());
            pstmt.setString(4, company.getCriteria());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }
    
    public List<Company> getAllCompanies()
    {
        List<Company> list = new ArrayList<>();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt =
                    conn.prepareStatement("select * from companies");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                Company company = new Company();

                company.setId(rs.getInt("cid"));
                company.setCompanyName(rs.getString("company_name"));
                company.setPackageName(rs.getString("package"));
                company.setLocation(rs.getString("location"));
                company.setCriteria(rs.getString("criteria"));

                list.add(company);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    
    
    public Company getCompanyById(int cid)
    {
        Company company = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt =
                    conn.prepareStatement(
                    "select * from companies where cid=?");

            pstmt.setInt(1, cid);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next())
            {
                company = new Company();

                company.setId(rs.getInt("cid"));

                company.setCompanyName(
                        rs.getString("company_name"));

                company.setPackageName(
                        rs.getString("package"));

                company.setLocation(
                        rs.getString("location"));

                company.setCriteria(
                        rs.getString("criteria"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return company;
    }

	@Override
	public boolean updateCompany(Company company) {
		boolean status = false;
		List<Company> list = new ArrayList<>();

        try 
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt =
                    conn.prepareStatement("update companies set company_name = ? , package =? ,  location = ?,  criteria =? where cid=?");
            pstmt.setString(1, company.getCompanyName());
            pstmt.setString(2, company.getPackageName());
            pstmt.setString(3, company.getLocation());
            pstmt.setString(4, company.getCriteria());
            pstmt.setInt(5, company.getId());
            int val = pstmt.executeUpdate();
            
            if(val>0)
            {
            	status = true;
            }
           
        }
        catch(Exception ex)
        {
        	System.out.println("Error is " + ex);
        }
        return status;
	}

	@Override
	public boolean deleteCompany(int cid)
	{
	    boolean status = false;

	    try
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/placement_tracking_system",
	                "root",
	                "Dhiraj@1432");

	        PreparedStatement pstmt =
	                conn.prepareStatement(
	                "delete from companies where cid=?");

	        pstmt.setInt(1, cid);

	        int value = pstmt.executeUpdate();

	        if(value > 0)
	        {
	            status = true;
	        }

	        pstmt.close();

	        conn.close();
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error is " + ex);
	    }

	    return status;
	}
    
}