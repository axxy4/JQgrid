package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.Bean.StudentDemo;
import com.demo.DAO.StudentDAO;

@WebServlet("/UpdateGridStudent")
public class UpdateGridStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();

		Connection con = (Connection) httpSession.getAttribute("connection");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		
		StudentDemo e = dao.getStudentById(id,con);
		
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String state = request.getParameter("state");
		
		System.out.println("Student firstname is :"+firstname);
		System.out.println("Student lastname is :"+lastname);
		System.out.println("Student email is :"+email);
		System.out.println("Student mobile is :"+mobile);
		System.out.println("Student state is :"+state);
		
		e.setId(id);
		e.setFirstname(firstname);
		e.setLastname(lastname);
		e.setEmail(email);
		e.setMobile(mobile);
		e.setState(state);

		int status = dao.updateStudent(e,con);
		if (status > 0) {
		} else {
			out.println("Not Updated");
		}
		
	
	}

}
