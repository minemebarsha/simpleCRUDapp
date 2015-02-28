<%@page import="com.checker.Checker"%>
<%

if(!Checker.isLoggedIn(request.getSession())){
	response.sendRedirect("signin.jsp?error=Please Sign in!");
}
%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Admin"%>
<%@page import="com.db.AdminManager"%>
<%@ include file="includes/header.jsp"%>
<div class="jumbotron">
	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Admin> arrayList = AdminManager.getAllAdmin();
				for (Admin admin : arrayList) {
			%>
	
			<tr>
				<td><%=admin.getAdmin_id()%></td>
				<td><%=admin.getName()%></td>
				<td><%=admin.getPassword()%></td>
				<td><a class="btn btn-default" href="edit.jsp?id=<%=admin.getAdmin_id()%>">Edit</a></td>
				<td><a class="btn btn-default" href="DeleteServlet?id=<%=admin.getAdmin_id()%>">Delete</a></td>
			</tr>
	
			<%
				}
			%>
		</tbody>
	</table>
</div>
<%@ include file="includes/footer.jsp"%>