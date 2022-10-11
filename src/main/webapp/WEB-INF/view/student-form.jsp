<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
<form:form modelAttribute="student" action="processForm" method="POST">
    First Name
    <form:input path="firstName" placeholder="First Name"/>
    <br>
    Last Name
    <form:input path="lastName" placeholder="Last Name"/>
    <br>
    country
    <form:select path="country">
        <form:options items="${theCountryOptions}"/>
    </form:select>
    <br>
    Favourite Language:

    Java <form:radiobutton path="favouriteLanguage" value="Java"/>

    C# <form:radiobutton path="favouriteLanguage" value="C#"/>

    PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>

    Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>
    <br>
    Operating Systems:

    Linux <form:checkbox path="operatingSystems" value="linux"/>
    Mac Os <form:checkbox path="operatingSystems" value="Mac Os"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    <br> <br>
    <input type="submit" value="submit">
</form:form>
</body>
</html>
