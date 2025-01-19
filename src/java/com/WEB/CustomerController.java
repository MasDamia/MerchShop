package com.WEB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import com.DAO.CustomerDAO;
import com.Model.Customer;

public class CustomerController extends HttpServlet {

    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/CustomerRegister":
                    register(request, response);
                    break;
                case "/CustomerLogin":
                    login(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String emailAddress = request.getParameter("emailAddress");

        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmailAddress(emailAddress);

        boolean isRegistered = customerDAO.registerCustomer(customer);

        if (isRegistered) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            session.setAttribute("customerID", customer.getCustomerID()); 
            response.sendRedirect("customerProfile.jsp"); // Redirect to a profile page
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("customerRegister.jsp").forward(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Customer customer = customerDAO.validateCustomer(username, password);

        if (customer != null) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            session.setAttribute("customerID", customer.getCustomerID()); 
            response.sendRedirect("displayItem"); // Redirect to orders dashboard
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("customerLogin.jsp").forward(request, response);
        }
    }
}