<%--
  Created by IntelliJ IDEA.
  User: kenny
  Date: 15-Jul-19
  Time: 2:08 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form action="create" controller="person">
    First Name:<br>
    <input type="text" name="firstName" required ><br>
    Last Name:<br>
    <input type="text" name="lastName" required><br>
    E-mail:<br>
    <input type="text" name="email" required><br>
    Phone Number:<br>
    <input type="'text" name="phoneNumber" required><br>
    Address:<br>
    <textarea name="address" required></textarea>
    <input type="submit">
</g:form>

</body>
</html>