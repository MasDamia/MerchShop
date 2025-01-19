
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container mt-5">
            <h3 class="text-center">Merchandise Shop</h3>
            <hr>
            <form action="OrdersController" method="post">
                <div class="row">
                    <c:forEach items="${listStock}" var="stock">
                        <div class="col-md-4">
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h5 class="card-title"><c:out value="${stock.stockName}"/></h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Price: RM<c:out value="${stock.stockPrice}"/></h6>

                                    <div class="form-group">
                                        <input type="checkbox" name="stockID" value="${stock.stockID}"> Select
                                        <input type="number" name="orderQtt${stock.stockID}" value="1" min="1" class="form-control mt-2" placeholder="Quantity">
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