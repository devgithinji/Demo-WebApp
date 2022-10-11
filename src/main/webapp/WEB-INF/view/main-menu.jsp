<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 10/10/22
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main menu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<h1>main menu</h1>
<img src="${pageContext.request.contextPath}/resources/images/hello.png" alt="hello image">
<hr>
<a href="hello/showForm">Hello World Form</a>
<br><br>
<a href="student/showForm">Student Show Form</a>
<br><br>
<a href="customer/showForm">Customer Show Form</a>
</body>
</html>
