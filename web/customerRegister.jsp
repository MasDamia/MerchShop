
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            .form-container {
                max-width: 400px;
                margin: 50px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            .btn-register {
                background-color: black;
                color: white;
                border: none;
                width: 100%;
                padding: 10px;
                font-weight: bold;
            }
            .btn-register:hover {
                background-color: #444;
            }
            .title {
                text-align: center;
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 10px;
            }
            .subtext {
                text-align: center;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <div class="header">
            Merchandise Shop
        </div>
        <div class="form-container">
            <h2 class="title">Create New Account</h2>
            <p class="subtext">Already Registered? <a href="customerLogin.jsp">Login</a></p>
            <form action="CustomerRegister" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="mb-3">
                    <label for="emailAddress" class="form-label">Email</label>
                    <input type="email" class="form-control" id="emailAddress" name="emailAddress" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-register">Register</button>
            </form>
        </div>
        <p style="color: red;">
            <% String errorMessage = (String) request.getAttribute("errorMessage");%>
            <%= errorMessage != null ? errorMessage : ""%>
        </p>
    </body>
</html>
