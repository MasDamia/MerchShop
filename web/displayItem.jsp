
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Merchandise Shop</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f5e4da;
            }
            .navbar {
                background-color: #ffd9e0;
            }
            .navbar-brand {
                font-weight: bold;
            }
            .card {
                background-color: #fbeee6;
                border: none;
            }
            .card img {
                width: 100%;
                height: 150px;
                object-fit: cover;
                border-radius: 5px;
            }
            .price {
                font-weight: bold;
                color: #333;
            }
            .quantity {
                text-align: center;
                margin-top: 10px;
            }
            .action-icons {
                margin-top: 10px;
                display: flex;
                justify-content: space-between;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Merchandise Shop</a>
                <div class="d-flex">
                    <span>Welcome!</span>
                    <a href="#" class="ms-3"><img src="user-icon.png" alt="User" style="width: 30px;"></a>
                    <a href="#" class="ms-3"><img src="cart-icon.png" alt="Cart" style="width: 30px;"></a>
                </div>
            </div>
        </nav>

        <div class="container mt-4">
            <!-- Added form action here -->
            <form action="OrdersController" method="post">
                <div class="row">
                    <c:forEach items="${listStock}" var="stock">
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <div class="card-body text-center">
                                    <h5 class="card-title"><c:out value="${stock.stockName}"/></h5>
                                    <p class="price">RM<c:out value="${stock.stockPrice}"/></p>
                                    <div class="quantity">
                                        <input type="checkbox" name="stockID" value="${stock.stockID}"> Select
                                        <input type="number" name="orderQtt${stock.stockID}" value="1" min="1" class="form-control mt-2">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Place Order</button>
                </div>
            </form>
        </div>
    </body>
</html>
