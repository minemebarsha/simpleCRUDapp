<%@page import="com.checker.Checker"%>
<%

if(!Checker.isLoggedIn(request.getSession())){
	response.sendRedirect("signin.jsp?error=Please Sign in!");
}
%>

<%@ include file="includes/header.jsp" %>
	<div class="jumbotron">
	<%
	HttpSession httpSession = request.getSession();
	String userName = (String) httpSession.getAttribute("userName");
	%>
        <h1>Hello, <%=userName %></h1>
        <p></p>
     </div>

<%@ include file="includes/footer.jsp" %>