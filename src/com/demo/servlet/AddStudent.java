package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.Bean.StudentDemo;
import com.demo.Connection.StudentConc;
import com.demo.DAO.StudentDAO;


@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

		PrintWriter out = response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String state = request.getParameter("state");
		
		HttpSession httpSession = request.getSession();
		
		Connection con = null;
		try {
			con = StudentConc.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StudentDemo std = new StudentDemo();
		StudentDAO dao = new StudentDAO();
		
		std.setFirstname(firstname);
		std.setLastname(lastname);
		std.setEmail(email);
		std.setMobile(mobile);
		std.setState(state);

		int result =dao.AddStudent(std,con);
		if (result > 0) {
			out.print("<p>Record saved</p>");
		} else {
			out.println("Unsaved!");
		}

		out.close();
		

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
