//package com.demo.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.demo.Bean.StudentDemo;
//import com.demo.Connection.StudentConc;
//
//import net.sf.json.JSONObject;
//
//
//@WebServlet("/SearchServ")
//public class SearchServ extends HttpServlet {
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out=response.getWriter();
//		
//		String firstname=request.getParameter("firstname");
//		String lastname=request.getParameter("lastname");
//		String email=request.getParameter("email");
//		String mobile=request.getParameter("mobile");
//		String state=request.getParameter("state");
//		StudentDemo h=new  StudentDemo();
//			 List <StudentDemo> list= new ArrayList<StudentDemo>();
//			try {
//				
//				Connection con=StudentConc.getConnection();
//				PreparedStatement ps=con.prepareStatement("Select * from student where firstname=?");
//				ps.setString(1, firstname);
//				ps.setString(2, lastname);
//				ps.setString(3, email);
//				ps.setString(4, mobile);
//				ps.setString(5, state);
//
//
//				ResultSet rs=ps.executeQuery();
//				while(rs.next())
//				{
//				
//				h.setFirstname(rs.getString(1));
//				h.setLastname(rs.getString(2));
//				h.setEmail(rs.getString(3));
//				h.setMobile(rs.getString(4));
//				h.setState(rs.getString(5));
//				list.add(h);
//				}
//				JSONObject mainObj = new JSONObject();
//			mainObj.put("rows", list);
//				out.print(mainObj.toString());
//			}catch(Exception e) {e.printStackTrace();}
//	}
//
//}

package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Bean.StudentDemo;
import com.demo.Connection.StudentConc;

import net.sf.json.JSONObject;


@WebServlet("/SearchServ")
public class SearchServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String firstname=request.getParameter("firstname");
		StudentDemo h=new  StudentDemo();
			 List <StudentDemo> list= new ArrayList<StudentDemo>();
			try {
				
				Connection con=StudentConc.getConnection();
				PreparedStatement ps=con.prepareStatement("Select * from student where firstname=?");
				ps.setString(1, firstname);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
				
				h.setFirstname(rs.getString(1));
				list.add(h);
				}
				JSONObject mainObj = new JSONObject();
			mainObj.put("rows", list);
				out.print(mainObj.toString());
			}catch(Exception e) {e.printStackTrace();}
	}

}

