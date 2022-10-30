<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Name: ${product.name }
Product Id: ${product.id }
Description :${product.description }
Pice:${product.price }

<a href="update/${product.id}">update</a>

</body>
</html>