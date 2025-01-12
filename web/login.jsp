<%-- 
    Document   : login
    Created on : 11 Jan 2025, 9:12:52 pm
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
        <form action="ManagerServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <button type="submit">Login</button>
        </form>
        <p style="color: red;">
            <% String errorMessage = (String) request.getAttribute("errorMessage");%>
            <%= errorMessage != null ? errorMessage : ""%>
        </p>
    </body>
</html>
