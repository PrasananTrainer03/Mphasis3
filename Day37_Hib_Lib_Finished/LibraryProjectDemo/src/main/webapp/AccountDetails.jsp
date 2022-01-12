<%@page import="java.util.List"%>
<%@page import="com.java.lib.TranBook"%>
<%@page import="com.java.lib.LibraryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp" />
<%
	String user = (String) session.getAttribute("user");
	List<TranBook> arrTbook = new LibraryDAO().issuedBooks(user);
%>
	<table border="3">
		<tr>
		  <th>Transaction ID</th>
		  <th>UserName</th>
		  <th>Book Id</th>
		  <th>From Date</th>
		</tr>
	<%
		for(TranBook t : arrTbook) {
	%>
		<tr>
			<td><%=t.getTid() %> </td>
			<td><%=t.getUserName() %></td>
			<td><%=t.getBookId() %> </td>
			<td><%=t.getFromDate() %> </td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>