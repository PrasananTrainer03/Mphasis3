<%@page import="com.java.lib.LibraryDAO"%>
<%@page import="com.java.lib.Books"%>
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
<jsp:include page="menu.jsp"/><br/>
	<%
	String searchtype=request.getParameter("searchtype");
	String searchvalue=request.getParameter("searchvalue");
	List<Books> lst=new LibraryDAO().searchBooks(searchtype,searchvalue);
	if(lst==null){
	%>
	<form action='Search.jsp' method="post">
		Sorry !... <br/> 
		No book found for the Search Criteria<br/><br/>
		<input type='submit' value='Return'>
	</form>
	<%
	}else{%>
		<br/> Select books to issue: <br/> 
	<form action="Issue.jsp" method="post">
	<table border='3'>
		<tr>
		 <th>Id </th>
		 <th>Name</th>
		 <th>Author</th>
		 <th>Edition</th>
		 <th>Dept</th>
		 <th>Total Books</th>
		 <th> Select </th>
	    </tr>
	 <%
	 	for(Books b:lst){
	 		int bid=b.getId();
	 		String bname=b.getName();
	 		String bauthor=b.getAuthor();
	 		String bedition=b.getEdition();
	 		String bdept=b.getDept();
	 		int btotal=b.getTotalBooks();
	 %>
      	 <tr>
      	   <td><%=bid%></td>
      	   <td><%=bname%></td>
      	   <td><%=bauthor%></td>
		   <td><%=bedition%></td>
		   <td><%=bdept%></td>
		   <td><%=btotal%></td>
	 <%
	 	if(btotal > 0){
	 %>
	 		<td><input type="checkbox" name="bookid" value="<%=bid%>" /></td>
	 	  </tr>
	 <%		
	 	 }else{
	 %>
	 		<td><input type="checkbox" name="bookid" disabled="true" value="<%=bid%>" /></td>
	 	  </tr>
	 <%
	 	 }
	 	}
	 %>
	
	 </table>
	 <br/>
	 <input type='submit' value='Issue Books' >
	</form>
	<%} %>
</body>
</html>