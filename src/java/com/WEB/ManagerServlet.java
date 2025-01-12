
package com.WEB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ManagerDAO;
import com.Model.Manager;
import javax.servlet.http.HttpSession;

public class ManagerServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ManagerDAO managerDAO = new ManagerDAO();
        Manager manager = managerDAO.validateManager(username, password);

        if (manager != null) {
            HttpSession session = request.getSession();
            session.setAttribute("manager", manager);
            response.sendRedirect("listStock"); // Redirect to inventory dashboard
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
