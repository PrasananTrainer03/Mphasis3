<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
       <table border="3">
        	<tr>
        		<th>Customer Id</th>
        		<th>Customer Name</th>
        		<th>City</th>
        		<th>State</th>
        		<th>Email</th>
        		<th>Mobile</th>
        		  <th>Update</th>
                <th>Delete</th>
        	</tr>
        <c:forEach var="customer" items="${listCustomer}">
        	<tr>
        		<td>${customer.customerId}</td>
        		<td>${customer.customerName}</td>
        		<td>${customer.customerCity}</td>
        		<td>${customer.customerState}</td>
        		<td>${customer.customerEmail}</td>
        		<td>${customer.customerMobile}</td>
        		 <td>
                   <a href="editcustomer?custid=${customer.customerId}">Edit</a>
                 </td>
                 <td>
                   <a href="deletecustomer?custid=${customer.customerId}">Delete</a>
                  </td>
        		
        	</tr>
        </c:forEach>
        </table>
            <h3><a href="newemploy">New Employ</a></h3>
       
    </body>
</html>
