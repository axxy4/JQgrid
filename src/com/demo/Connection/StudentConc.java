package com.demo.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.Bean.StudentDemo;


public class StudentConc {

	private static StudentConc connectionFactory = null;


	public static Connection getConnection() throws SQLException {

		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdemo","root","root");
			
		} catch ( Exception e) {
			e.printStackTrace();
			}
		
		return con;
		}

	public static StudentConc getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new StudentConc();
		}
		return connectionFactory;
	}
	
	
	public static int edit(StudentDemo h) throws SQLException {
		int status = 0;
		Connection con = null;
		con = StudentConc.getConnection();
		PreparedStatement ps = con.prepareStatement("update student set mobile=? where id=?");

		ps.setString(1, h.getMobile());
		ps.setInt(2, h.getId());
		
		
		status = ps.executeUpdate();
		con.close();
		return status;
	}




	
}
