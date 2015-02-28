<%@page import="com.checker.Checker"%>
<%

if(!Checker.isLoggedIn(request.getSession())){
	response.sendRedirect("signin.jsp?error=Please Sign in!");
}
%>
<%@page import="com.db.AdminManager"%>
<%@page import="com.bean.Admin"%>
<%@page import="com.checker.Checker"%>
<%-- <%

if(!Checker.isLoggedIn(request.getSession())){
	response.sendRedirect("signin.jsp?error=Please Sign in!");
}
%> --%>
<%@ include file="includes/header.jsp" %>


	<form action="EditServlet" class="form-signin" method="post">
	
		<%
		String error = request.getParameter("error");
		if(error!=null){
		%>
		
		<div class="alert alert-danger" role="alert">
		  <span class="alert-link"><%=error %></span>
		</div>
		
		<%
			
		}
		%>
		
		<%
		int admin_id = Integer.parseInt(request.getParameter("id"));
		request.getSession().setAttribute("EditingAdminId", admin_id);
		Admin admin = AdminManager.getAdminById(admin_id);
		%>
	
        <h2 class="form-signin-heading">Please Register</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" value="<%=admin.getName() %>" name="userName" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" value="<%=admin.getPassword() %>" name="pass" id="inputPassword" class="form-control" placeholder="Password" required>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Update" >
        
        <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> -->
        
      </form>



<%@ include file="includes/footer.jsp" %>