<%-- 
    Document   : register
    Created on : 12 Jan 2025, 2:45:58 pm
    Author     : masda
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Merchandise Shop</title>
    </head>
    <body>
        <form action="RegisterServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" value="<c:out value="${staff.username}"/>" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" name="password" value="<c:out value="${staff.password}"/>" required>
            <br>
            <label for="emailAddress">Email Address:</label>
            <input type="email" name="emailAddress" value="<c:out value="${staff.emailAddress}"/>" required>
            <br>
            <button type="submit">Register</button>
        </form>
        <p style="color: red;">
            <% String errorMessage = (String) request.getAttribute("errorMessage");%>
            <%= errorMessage != null ? errorMessage : ""%>
        </p>
    </body>
</html>
