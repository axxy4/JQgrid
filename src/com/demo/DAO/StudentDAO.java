package com.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.Bean.StudentDemo;
import com.demo.Connection.StudentConc;


public class StudentDAO {
	
	

	public int AddStudent(StudentDemo std, Connection connection) {
		int status = 0;
		try {

			PreparedStatement ps = connection.prepareStatement(
					"insert into student(firstname, lastname, email, mobile, state) values (?,?,?,?,?)");

			ps.setString(1, std.getFirstname());
			ps.setString(2, std.getLastname());
			ps.setString(3, std.getEmail());
			ps.setString(4, std.getMobile());
			ps.setString(5, std.getState());

			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

//		***********************************************************

	public int updateStudent(StudentDemo std, Connection connection) {
		int status = 0;
		try {

			PreparedStatement ps = connection
					.prepareStatement("update student set firstname=?,lastname=?,email=?, mobile=?, state=? where id=?");
			ps.setInt(1, std.getId());
			ps.setString(2, std.getFirstname());
			ps.setString(3, std.getLastname());
			ps.setString(4, std.getEmail());
			ps.setString(5, std.getMobile());
			ps.setString(6, std.getState());

			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
//		*****************************************************************

	public int deleteStudent(int id, Connection connection) {
		int status = 0;
		try {

			PreparedStatement ps = connection.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
//		*******************************************************************

	public StudentDemo getStudentById(int id, Connection connection) {
		StudentDemo e = new StudentDemo();

		try {

			PreparedStatement ps = connection.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setMobile(rs.getString(5));
				e.setState(rs.getString(6));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
	
//	************************************************************************

	public List<StudentDemo> getAllStudent(Connection connection) {
		List<StudentDemo> list = new ArrayList<StudentDemo>();

		try {

			PreparedStatement ps = connection.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentDemo e = new StudentDemo();
				
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setMobile(rs.getString(5));
				e.setState(rs.getString(6));
				
				list.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
//	*************************************************************************
	
	public static int edit(StudentDemo h) throws SQLException {
		int status = 0;
		Connection con = null;
		con = StudentConc.getConnection();
		PreparedStatement ps = con.prepareStatement("update student set mobile=? where id=?");

		ps.setInt(1, h.getId());
		ps.setString(2, h.getFirstname());
		ps.setString(3, h.getLastname());
		ps.setString(4, h.getEmail());
		ps.setString(5, h.getMobile());
		ps.setString(6, h.getState());
		
		
		status = ps.executeUpdate();
		con.close();
		return status;
	}
	

}
