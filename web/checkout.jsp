<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h3>Checkout</h3>
        <form action="placeOrder" method="POST">
            <table class="table">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.stockName}</td>
                            <td>${order.orderQtt}</td>
                            <td>RM${order.totalPrice}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <label for="address">Shipping Address:</label>
            <input type="text" id="address" name="address" required />
            <button type="submit" class="btn btn-success">Complete Order</button>
        </form>
    </div>
</body>
</html>

