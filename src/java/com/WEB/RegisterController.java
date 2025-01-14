package com.WEB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.StaffDAO;
import com.Model.Staff;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String emailAddress = request.getParameter("emailAddress");

        Staff staff = new Staff();
        staff.setUsername(username);
        staff.setPassword(password);
        staff.setEmailAddress(emailAddress);

        StaffDAO staffDAO = new StaffDAO();
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
}
