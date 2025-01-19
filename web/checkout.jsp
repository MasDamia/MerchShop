<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Checkout</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h3 class="text-center">Order Confirmation</h3>
            <hr>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Total Price (RM)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ordersList}" var="order">
                        <tr>
                            <td><c:out value="${order.stockName}"/></td>
                            <td><c:out value="${order.orderQtt}"/></td>
                            <td><c:out value="${order.totalPrice}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <div class="text-center">
                <a href="<%=request.getContextPath()%>/displayItem" class="btn btn-primary">Back To Menu</a>
            </div>
            <br>
            <div class="text-center">
                <a href="orderSuccess.jsp" class="btn btn-primary">Pay</a>
            </div>
        </div>
    </body>
</html>

