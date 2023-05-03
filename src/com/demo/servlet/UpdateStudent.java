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


@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

		StudentDAO dao = new StudentDAO();
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Student</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		HttpSession httpSession = request.getSession();

		Connection con = (Connection) httpSession.getAttribute("connection");

		StudentDemo e = dao.getStudentById(id,con);

		out.print("<form action='UpdateStudent2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>FirstName:</td><td><input type='text' name='firstname' value='" + e.getFirstname() + "'/></td></tr>");
		out.print("<tr><td>Lastname:</td><td><input type=' text' name='lastname' value='" + e.getLastname() + "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='Email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>Mobile:</td><td><input type='mobile' name='Mobile' value='" + e.getMobile() + "'/></td></tr>");
		out.print("<tr><td>State:</td><td><input type='text' name='s' value='" + e.getState() + "'/></td></tr>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
