<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 10/10/22
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br>
Country ${student.country}
<br>
Favourite Language ${student.favouriteLanguage}
<br>
Operating Systems:

<ul>
   <c:forEach var="temp" items="${student.operatingSystems}">
       <li>${temp}</li>
   </c:forEach>
</ul>
</body>
</html>
