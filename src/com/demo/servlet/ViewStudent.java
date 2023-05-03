package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.Bean.StudentDemo;
import com.demo.DAO.StudentDAO;

@WebServlet("/ViewStudent")
	public class ViewStudent extends HttpServlet {
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
			HttpSession httpSession = request.getSession();

			Connection con = (Connection) httpSession.getAttribute("connection");

			PrintWriter out = response.getWriter();
			
			List<StudentDemo> list = dao.getAllStudent(con);
				out.println("<a href='index.jsp'>Add Student</a>");

				out.print("<h1> STUDENT LIST  </h1>");
				out.print("<table border='1' cellpadding='4' width='60%'>");
				out.print("<tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><th>State</th><th>Update</th><th>Delete</th>");
				for (StudentDemo e : list) {
					out.print("<tr><td>" + e.getId() + "</td><td>" + e.getFirstname() + "</td>" + "<td>" + e.getLastname() + "</td><td>" + e.getEmail() + "</td><td>" + e.getMobile() + "</td><td>" + e.getState() + "</td><td>"
									+ "<a href='UpdateStudent?id=" + e.getId() + "'>"
									+ "Edit</a></td><td><a href='DeleteStudent?id=" + e.getId() + "'>Delete</a></td></tr>");
				}
				out.print("</table>");

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
		}

	}



