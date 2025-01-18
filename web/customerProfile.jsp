
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Model.Customer" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Merchandise Shop</title>
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

            .card {
                max-width: 400px;
                margin: 20px auto;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            .card-title {
                font-size: 24px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="header">
            Merchandise Shop
        </div>
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
                response.sendRedirect("customerRegister.jsp");
            }
        %>
        <div class="card bg-light">
            <div class="card-body">
                <h5 class="card-title text-center">Registration Successful!</h5>
                <p class="card-text">
                    <strong>Email Address:</strong> <%= customer.getEmailAddress() %>
                </p>
                <p class="card-text">
                    <strong>Username:</strong> <%= customer.getUsername() %>
                </p>
                <div class="d-flex justify-content-center">
                    <a href="customerLogin.jsp" class="btn btn-primary">Go to Login</a>
                </div>
            </div>
        </div>
    </body>
</html>
