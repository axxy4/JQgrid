package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.Bean.StudentDemo;
import com.demo.Connection.StudentConc;
import com.demo.DAO.StudentDAO;

import net.sf.json.JSONObject;

@WebServlet("/JqgridStudent")
public class JqgridStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		HttpSession httpSession = request.getSession();
//		Connection con = (Connection) httpSession.getAttribute("connection");
		Connection con = null;
		try {
			con = StudentConc.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();

		List<StudentDemo> list = new ArrayList<StudentDemo>();
		list = dao.getAllStudent(con);
		if (list != null) {
			System.out.println("Not Null");
			list.forEach(data -> {
				System.out.println("List Student is : " + data.toString());
			});

		}

		JSONObject mainObj = new JSONObject();
		mainObj.put("page", 1);
		mainObj.put("total", 1);
		mainObj.put("records", 1);
		mainObj.put("rows", list);
		out.print(mainObj.toString());
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		
//
//	}

}
