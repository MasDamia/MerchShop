<%-- 
    Document   : profile
    Created on : 12 Jan 2025, 2:48:06 pm
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
        <h2>Staff Registration Successful!</h2>
        <div>
            <table>
                <tbody>
                    <tr>
                        <th scope="row">Email Address</th>
                        <td><c:out value="${staff.emailAddress}" /></td>
                    </tr>
                    <tr>
                        <th scope="row">Username</th>
                        <td><c:out value="${staff.username}" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <a href="staffLogin.jsp">Go to Login</a>
    </body>
</html>
