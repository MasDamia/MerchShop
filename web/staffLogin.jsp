<%-- 
    Document   : staffLogin
    Created on : 12 Jan 2025, 2:03:11 pm
    Author     : masda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Merchandise Shop</title>
    </head>
    <body>
        <form action="StaffServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <button type="submit">Login</button>
        </form>
        <div>
            <p>Don't have an account? <a href="register.jsp">Register here.</a></p>
        </div>
        <p style="color: red;">
            <% String errorMessage = (String) request.getAttribute("errorMessage");%>
            <%= errorMessage != null ? errorMessage : ""%>
        </p>
    </body>
</html>
