<%
	HttpSession httpSession = request.getSession();
	httpSession.invalidate();
	response.sendRedirect("signin.jsp?suc=Sucessfullt logged out...");
%>