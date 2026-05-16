package com.spts.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.spts.model.Student;

public class StudentRepository implements StudentRepositoryInterface {

    public List<Student> getAllStudents()
    {
        List<Student> list = new ArrayList<>();

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_tracking_system",
                    "root",
                    "Dhiraj@1432");

            PreparedStatement pstmt =
                    conn.prepareStatement(
                    "select * from students");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                Student student = new Student();

                student.setSid(rs.getInt("sid"));

                student.setName(rs.getString("name"));

                student.setEmail(rs.getString("email"));

                student.setMobile(rs.getString("mobile"));

                student.setCourse(rs.getString("course"));

                student.setPercentage(
                        rs.getDouble("percentage"));

                student.setSkills(
                        rs.getString("skills"));

                student.setPassword(
                        rs.getString("password"));

                list.add(student);
            }

            rs.close();

            pstmt.close();

            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error is " + ex);
        }

        return list;
    }

	@Override
	public Student getStudentById(int sid)
	{
	    Student student = null;

	    try
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/placement_tracking_system",
	            "root",
	            "Dhiraj@1432");

	        PreparedStatement pstmt =
	            conn.prepareStatement(
	            "select * from students where sid=?");

	        pstmt.setInt(1, sid);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next())
	        {
	            student = new Student();

	            student.setSid(rs.getInt("sid"));
	            student.setName(rs.getString("name"));
	            student.setEmail(rs.getString("email"));
	            student.setMobile(rs.getString("mobile"));
	            student.setCourse(rs.getString("course"));
	            student.setPercentage(rs.getDouble("percentage"));
	            student.setSkills(rs.getString("skills"));
	            student.setPassword(rs.getString("password"));
	        }

	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }

	    return student;
	}
	
	public boolean updateStudentProfile1(Student student)
	{
	    boolean status = false;

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/placement_tracking_system",
	                "root",
	                "Dhiraj@1432");

	        PreparedStatement pstmt =
	                conn.prepareStatement(
	                "update students set name=?, email=?, mobile=?, course=?, percentage=?, skills=?, password=? where sid=?");

	        pstmt.setString(1, student.getName());

	        pstmt.setString(2, student.getEmail());

	        pstmt.setString(3, student.getMobile());

	        pstmt.setString(4, student.getCourse());

	        pstmt.setDouble(5, student.getPercentage());

	        pstmt.setString(6, student.getSkills());

	        pstmt.setString(7, student.getPassword());

	        pstmt.setInt(8, student.getSid());

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
	
	public boolean updateStudentProfile(Student student)
	{
	    boolean status = false;

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/placement_tracking_system",
	                "root",
	                "Dhiraj@1432");

	        PreparedStatement pstmt =
	                conn.prepareStatement(
	                "update students set name=?, email=?, mobile=?, course=?, percentage=?, skills=?, password=? where sid=?");

	        pstmt.setString(1, student.getName());

	        pstmt.setString(2, student.getEmail());

	        pstmt.setString(3, student.getMobile());

	        pstmt.setString(4, student.getCourse());

	        pstmt.setDouble(5, student.getPercentage());

	        pstmt.setString(6, student.getSkills());

	        pstmt.setString(7, student.getPassword());

	        pstmt.setInt(8, student.getSid());

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
	
}