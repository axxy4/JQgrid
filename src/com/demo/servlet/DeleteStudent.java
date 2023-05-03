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

import com.demo.Connection.StudentConc;
import com.demo.DAO.StudentDAO;

import net.sf.json.JSONObject;


@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//
//	}

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		processRequest(request, response);
//
//		HttpSession httpSession = request.getSession();
//
//		Connection con = (Connection) httpSession.getAttribute("connection");
//		StudentDAO dao = new StudentDAO();
//		String sid = request.getParameter("id");
//		int id = Integer.parseInt(sid);
//		dao.deleteStudent(id,con);
//		
//
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter  out = response.getWriter();
		Connection con = null;
		try {
			con = StudentConc.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StudentDAO dao = new StudentDAO();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		int status = dao.deleteStudent(id,con);
		String msg = "";
		if(status > 0) {
			msg = "success";
		}else {
			msg = "error";
			
		}
		JSONObject obj = new JSONObject();
		obj.put("msg", msg);
		
		out.print(obj);
		
	}



}
