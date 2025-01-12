<%-- 
    Document   : stockForm
    Created on : 12 Jan 2025, 5:01:28 pm
    Author     : masda
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .navbar {
                background-color: #ffc0cb; /* Light pink for navbar */
                padding: 10px 20px;
                border-bottom: 2px solid #e9c8c8;
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
            .container2 {
                max-width: 90%;
                margin: auto;
                background-color: #f7e9dc; /* Beige */
                border-radius: 10px;
                padding: 20px;
            }
            
            .container {
                max-width: 600px;
                margin: 50px auto;
                background-color: #ffc0cb; /* Light pink background for form */
                border-radius: 10px;
                padding: 20px 40px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }
            h2 {
                text-align: center;
                color: #000;
                font-weight: bold;
                margin-bottom: 20px;
            }
            h3 {
                color: #6c757d; /* Neutral text color */
                text-align: left;
                margin-bottom: 20px;
            }
            label {
                font-weight: bold;
            }
            .btn-primary {
                display: block;
                width: 100%;
                background-color: #e9c8c8;
                border: none;
                color: black;
                font-weight: bold;
                padding: 10px;
                border-radius: 10px;
                transition: 0.3s;
            }
            .btn-primary:hover {
                background-color: #d8b4b4;
            }
            .btn-back {
                display: inline-block;
                background-color: white;
                border: 1px solid #d8b4b4;
                color: black;
                padding: 8px 20px;
                border-radius: 10px;
                font-weight: bold;
                margin-top: 10px;
                float: right;
                text-decoration: none;
            }
            .btn-back:hover {
                background-color: #e9c8c8;
            }
            input[type="text"],
            input[type="number"] {
                border-radius: 10px;
                border: 1px solid #d8b4b4;
                padding: 10px;
                width: 100%;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <!-- Navigation Bar -->
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

        <div class="container2">
            <h3>Inventory</h3>
            <div>
                <a href="listStock" class="btn-back">Back</a>
            </div>

            <!-- Add/Update Stock Form -->
            <div class="container">

                <c:if test="${stock != null}">
                    <form action="update" method="post">
                    </c:if>
                    <c:if test="${stock == null}">
                        <form action="insert" method="post">
                        </c:if>
                        <!-- Form Title -->
                        <h2>
                            <c:if test="${stock != null}">Update Stock</c:if>
                            <c:if test="${stock == null}">Add New Stock</c:if>
                            </h2>

                            <!-- Hidden Field for Stock ID (Update Only) -->
                        <c:if test="${stock != null}">
                            <input type="hidden" name="stockID" value="<c:out value="${stock.stockID}" />" />
                        </c:if>

                        <!-- Product Name Field -->
                        <label for="stockName">Product Name</label>
                        <input type="text" id="stockName" name="stockName" value="<c:out value="${stock.stockName}" />" maxlength="100" required placeholder="Enter product name" />

                        <!-- Price Field -->
                        <label for="stockPrice">Price Per Unit</label>
                        <input type="text" id="stockPrice" name="stockPrice" value="<c:out value="${stock.stockPrice}" />" required placeholder="0.00" />

                        <!-- Quantity Field -->
                        <label for="stockQtt">Stock Quantity</label>
                        <input type="number" id="stockQtt" name="stockQtt" value="<c:out value="${stock.stockQtt}" />" min="0" required placeholder="Enter quantity" />

                        <!-- Submit Button -->
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
            </div>
        </div>
    </body>
</html>
