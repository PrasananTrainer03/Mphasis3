<%@page import="com.java.lib.LibraryDAO"%>
<%@page import="com.java.lib.TranBook"%>
<%@page import="java.util.List"%>
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
<form method="get" action="ReturnNext.jsp">
	<table border="3">
		<tr>
		  <th>Transaction ID</th>
		  <th>UserName</th>
		  <th>Book Id</th>
		  <th>From Date</th>
		  <th>Return</th>
		</tr>
	<%
		for(TranBook t : arrTbook) {
	%>
		<tr>
			<td><%=t.getTid() %> </td>
			<td><%=t.getUserName() %></td>
			<td><%=t.getBookId() %> </td>
			<td><%=t.getFromDate() %> </td>
			<td><input type="checkbox" name="bookid" value="<%=t.getBookId()%>" /> </td>
		</tr>
	<%
		}
	%>
	</table>
	<br/><br/>
	<input type="submit" value="Return" />
	</form>
</body>
</html>