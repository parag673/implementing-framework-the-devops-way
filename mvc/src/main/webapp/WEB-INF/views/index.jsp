<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is my View...!!</h1>
<table>
<style>
 	 
 	 table,th,td{border:1px solid black;}
 	 </style>
 	 <tr>
 	 <td> S.No </td>
 	 <td>Product Name </td>
 	 <td>Description</td>
 	 <td>Price</td>
 	 <td>Action</td>
 	 </tr>
 	 <c:forEach items="${products }" var="p">
<tr>
<td>${p.id }</td>
<td>${p.name }</td>
<td>${p.description }</td>
<td>${p.price }</td>
<td><a href="delete/${p.id }">delete</a>
<a href="update/${p.id }">update</a>

</td>
</tr>

</c:forEach>
 	 
</table>
<a href="add-product">Add Product</a>
</body>
</html>