
package com.WEB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

