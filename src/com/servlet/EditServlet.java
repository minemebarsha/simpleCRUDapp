package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.db.AdminManager;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int admin_id =  (int) request.getSession().getAttribute("EditingAdminId");
		
		String name = request.getParameter("userName");
		String pass = request.getParameter("pass");
		Admin admin = new Admin();
		admin.setAdmin_id(admin_id);
		admin.setName(name);
		admin.setPassword(pass);
		if (AdminManager.update(admin)) {
			response.sendRedirect("list.jsp");
		} else {
			response.getWriter().print("Cannot update!");
		}

	
	
	}

}
