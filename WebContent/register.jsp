<%@page import="com.checker.Checker"%>
<%

if(Checker.isLoggedIn(request.getSession())){
	response.sendRedirect("profile.jsp");
}
%>
<%@ include file="includes/header.jsp" %>


	<form action="RegServlet" class="form-signin" method="post">
	
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
	
        <h2 class="form-signin-heading">Please Register</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" name="userName" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Password" required>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Register" >
        
        <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> -->
        
      </form>



<%@ include file="includes/footer.jsp" %>