<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="updatecustomer" method="post" modelAttribute="customer">
        <table>
            <tr>
            	<td>Customer Id</td>
            	<td><form:input path="customerId" /> 
            		
            	</td>
            </tr>
            <tr>
                <td>Customer Name:</td>
                <td><form:input path="customerName" /></td>
            </tr>
            <tr>
                <td>Customer City:</td>
                <td><form:input path="customerCity" /></td>
            </tr>
            <tr>
                <td>Customer State:</td>
                <td><form:input path="customerState" /></td>
            </tr>
            <tr>
                <td>Customer Email:</td>
                <td><form:input path="customerEmail" /></td>
            </tr>
            <tr>
      	<th>Gender</th>
      	<td>
      		 <form:input path="customerMobile" />
      	</td>
      	</tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Update"></td>
            </tr>
        </table>
        </form:form>

</body>
</html>