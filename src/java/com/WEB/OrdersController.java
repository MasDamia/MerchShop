
package com.WEB;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

import com.Model.Orders;
import com.DAO.OrdersDAO;

public class OrdersController extends HttpServlet {
    private OrdersDAO ordersDAO;
    
    public void init() {
        ordersDAO = new OrdersDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        List<Orders> orders = ordersDAO.getOrdersByCustomer(customerID);
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        int stockID = Integer.parseInt(request.getParameter("stockID"));
        int orderQtt = Integer.parseInt(request.getParameter("orderQtt"));
        String address = request.getParameter("address");

        // Get the stock price from the database 
        double stockPrice = Double.parseDouble(request.getParameter("stockPrice"));
        double totalPrice = orderQtt * stockPrice;

        Orders order = new Orders(0, customerID, stockID, orderQtt, totalPrice, new java.util.Date(), address);
        if (ordersDAO.placeOrder(order)) {
            // Update stock quantity after order
            int currentStockQtt = Integer.parseInt(request.getParameter("currentStockQtt"));
            int newStockQtt = currentStockQtt - orderQtt;
            ordersDAO.updateStockQuantity(stockID, newStockQtt);
        }

        response.sendRedirect("displayItem.jsp");
    }

}
