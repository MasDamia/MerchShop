<%-- 
    Document   : inventory
    Created on : 11 Jan 2025, 11:37:45 pm
    Author     : masda
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f7e9dc; /* Beige background */
                font-family: Arial, sans-serif;
            }
            .header {
                background-color: #ffc0cb; /* Light pink */
                padding: 15px;
                text-align: center;
                font-size: 20px;
                font-weight: bold;
                margin-bottom: 20px;
            }
            .container {
                max-width: 90%;
                margin: auto;
                background-color: #f7e9dc; /* Beige */
                border-radius: 10px;
                padding: 20px;
            }
            .navbar {
                background-color: #ffc0cb; /* Light pink for navbar */
                padding: 10px 20px;
                border-bottom: 2px solid #e9c8c8; /* Slightly darker border */
            }
            .navbar-brand {
                font-weight: bold;
                font-size: 24px;
            }
            .nav-item a {
                color: black;
                font-weight: bold;
                padding: 10px 20px;
                border-radius: 10px;
            }
            .nav-item a.active {
                background-color: #f7e9dc; /* Beige for active tab */
            }
            .user-icon {
                border-radius: 50%;
                background-color: white;
                padding: 10px;
                width: 40px;
                height: 40px;
                text-align: center;
                font-weight: bold;
            }
            h3 {
                color: #6c757d; /* Neutral text color */
                text-align: left;
                margin-bottom: 20px;
            }
            table {
                width: 100%;
                background-color: #ffc0cb; /* Light pink for table */
                border-collapse: separate;
                border-spacing: 0;
                border-radius: 10px;
                overflow: hidden;
            }
            table thead th {
                background-color: #e9c8c8; /* Header light pink */
                color: #000;
                text-align: center;
                padding: 15px;
            }
            table tbody tr td {
                text-align: center;
                padding: 10px;
                vertical-align: middle;
                border-bottom: 1px solid #f3dada;
            }
            .btn-new {
                display: flex;
                justify-content: flex-end;
                margin-bottom: 20px;
            }
            .btn {
                border-radius: 20px;
                padding: 5px 20px;
            }
            .btn-update {
                background: linear-gradient(to right, #a1c4fd, #c2e9fb); /* Gradient blue */
                border: none;
                color: #fff;
                font-weight: bold;
            }
            .btn-delete {
                background: #ff6b6b; /* Red button */
                border: none;
                color: #fff;
                font-weight: bold;
            }
        </style>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Merchandise Shop</a>
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="listStock">Inventory</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="report.jsp">Report</a>
                        </li>
                    </ul>
                </div>
                <div class="user-icon">
                    <span>👤</span>
                </div>
            </div>
        </nav>

        <div class="container">
            <h3>Inventory</h3>

            <div class="btn-new">
                <a href="<%= request.getContextPath()%>/new" class="btn btn-secondary">New</a>
            </div>

            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price Per Unit</th>
                        <th>Quantity</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listStock}" var="stock">
                        <tr>
                            <td><c:out value="${stock.stockName}" /></td>
                            <td>RM<c:out value="${stock.stockPrice}" /></td>
                            <td><c:out value="${stock.stockQtt}" /></td>
                            <td>
                                <a href="edit?stockID=<c:out value='${stock.stockID}' />" class="btn btn-update">Update</a>
                                <a href="delete?stockID=<c:out value='${stock.stockID}' />" onclick="return confirm('Are you sure you want to delete?')" class="btn btn-delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

