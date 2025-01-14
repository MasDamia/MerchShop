package com.WEB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import com.DAO.StaffDAO;
import com.Model.Staff;

public class RegisterController extends HttpServlet {

    private StaffDAO staffDAO;

    public void init() {
        staffDAO = new StaffDAO();
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
                case "/register":
                    register(request, response);
                    break;
                case "/login":
                    login(request, response);
                    break;
                case "/logout":
                    logout(request, response);
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

        Staff staff = new Staff();
        staff.setUsername(username);
        staff.setPassword(password);
        staff.setEmailAddress(emailAddress);

        boolean isRegistered = staffDAO.registerStaff(staff);

        if (isRegistered) {
            HttpSession session = request.getSession();
            session.setAttribute("staff", staff);
            response.sendRedirect("profile.jsp"); // Redirect to a profile page
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Staff staff = staffDAO.validateStaff(username, password);

        if (staff != null) {
            HttpSession session = request.getSession();
            session.setAttribute("staff", staff);
            response.sendRedirect("listStock"); // Redirect to inventory dashboard
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("staffLogin.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false); // Prevent creating a new session if none exists
        String redirectPage = "staffLogin.jsp"; // Default redirection

        if (session != null) {
            if (session.getAttribute("manager") != null) {
                redirectPage = "managerLogin.jsp"; // Manager login page
            }
            session.invalidate(); // Invalidate the session
        }
        response.sendRedirect(redirectPage); // Redirect to the correct login page
    }
}
