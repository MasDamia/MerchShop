package com.WEB;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

import com.Model.Orders;
import com.DAO.OrdersDAO;
import com.DAO.StockDAO;
import java.util.Date;
import java.util.ArrayList;

public class OrdersController extends HttpServlet {

    private OrdersDAO ordersDAO;
    private StockDAO stockDAO;

    public void init() {
        ordersDAO = new OrdersDAO();
        stockDAO = new StockDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer customerID = (Integer) session.getAttribute("customerID");

        if (customerID == null) {
            response.sendRedirect("customerLogin.jsp");
            return;
        }

        List<Orders> ordersList = new ArrayList<>();

        String[] stockIDs = request.getParameterValues("stockID");

        for (String stockIdStr : stockIDs) {
            int stockID = Integer.parseInt(stockIdStr);
            int orderQtt = Integer.parseInt(request.getParameter("orderQtt" + stockID));
            double stockPrice = stockDAO.getStockPriceById(stockID);
            double totalPrice = stockPrice * orderQtt;

            Orders order = new Orders();
            order.setCustomerID(customerID);
            order.setStockID(stockID);
            order.setOrderQtt(orderQtt);
            order.setTotalPrice(totalPrice);
            order.setStockName(stockDAO.getStockNameById(stockID));
            order.setOrderDate(new Date()); // Set the current date as the order date
            ordersList.add(order);
        }

        ordersDAO.placeOrder(ordersList);

        request.setAttribute("ordersList", ordersList);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Orders> ordersList = ordersDAO.getAllOrders();

        for (Orders order : ordersList) {
            System.out.println(order);
        }

        request.setAttribute("ordersList", ordersList);
        request.getRequestDispatcher("viewOrder.jsp").forward(request, response);
    }

}
