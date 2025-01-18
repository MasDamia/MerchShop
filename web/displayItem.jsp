
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h3>Available Items for Order</h3>
        <form action="placeOrder" method="POST">
            <table class="table">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Price</th>
                        <th>Stock Quantity</th>
                        <th>Quantity to Order</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="stock" items="${listStock}">
                        <tr>
                            <td>${stock.stockName}</td>
                            <td>RM${stock.stockPrice}</td>
                            <td>${stock.stockQtt}</td>
                            <td><input type="number" name="orderQtt" min="1" max="${stock.stockQtt}" /></td>
                            <td>
                                <button type="submit" class="btn btn-primary" name="stockID" value="${stock.stockID}">Add to Cart</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>

