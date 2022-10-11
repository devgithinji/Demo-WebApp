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
    <title>Customer Confirmation</title>
</head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br>
FreePasses ${customer.freePasses}
<br><br>
Postal Code ${customer.postalCode}
</body>
</html>
