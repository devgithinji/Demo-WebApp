<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 10/11/22
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<p>Fill all the fields marked with (*)</p>
<br><br>
<form:form action="processForm" modelAttribute="customer">
    First Name: <form:input path="firstName"/>
    <br><br>
    Last Name (*): <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    FreePasses (*): <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br><br>
    PostalCode (*): <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br><br>
    CourseCode (*): <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
