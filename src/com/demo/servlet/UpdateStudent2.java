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


@WebServlet("/UpdateStudent2")
public class UpdateStudent2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();

		Connection con = (Connection) httpSession.getAttribute("connection");

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("Email");
		String mobile = request.getParameter("Mobile");
		String state = request.getParameter("state");

		StudentDemo e = new StudentDemo();
		StudentDAO dao = new StudentDAO();
		e.setId(id);
		e.setFirstname(firstname);
		e.setLastname(lastname);
		e.setEmail(email);
		e.setMobile(mobile);
		e.setState(state);

		int status = dao.updateStudent(e,con);
		if (status > 0) {
			response.sendRedirect("ViewStudent?page=1");
		} else {
			out.println("Not Updated");
		}

		out.close();

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
