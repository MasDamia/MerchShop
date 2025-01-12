
package com.WEB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Staff;
import com.DAO.StaffDAO;
import javax.servlet.http.HttpSession;

public class StaffServlet extends HttpServlet {

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

        StaffDAO staffDAO = new StaffDAO();
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

}
