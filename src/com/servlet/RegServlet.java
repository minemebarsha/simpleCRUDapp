package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.db.AdminManager;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("userName");
		String pass = request.getParameter("pass");

		if (AdminManager.isNameExist(name)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp?suc=You are already Registered! Please Signin now....");
			dispatcher.forward(request, response);
		}

		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(pass);
		if (AdminManager.insert(admin)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp?suc=Registration Sucessful! Please Signin now....");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("register.jsp?error=Cannot Register! Please try again.....");

		}

	}

}
