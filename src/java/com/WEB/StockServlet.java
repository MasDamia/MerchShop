
package com.WEB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Stock;
import com.DAO.StockDAO;
import javax.servlet.RequestDispatcher;

@WebServlet("/")
public class StockServlet extends HttpServlet {
    private StockDAO stockDAO;
    
    public void init(){
        stockDAO = new StockDAO();
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
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStock(request, response);
                    break;
                case "/delete":
                    deleteStock(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStock(request, response);
                    break;
                default:
                    listStock(request, response);
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

    private void listStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Stock> listStock = stockDAO.selectAllStocks();
        request.setAttribute("listStock", listStock);
        RequestDispatcher dispatcher = request.getRequestDispatcher("inventory.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("stockForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int stockID = Integer.parseInt(request.getParameter("stockID"));
        Stock existingStock = stockDAO.selectStock(stockID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("stockForm.jsp");
        request.setAttribute("stock", existingStock);
        dispatcher.forward(request, response);
    }
    
    private void insertStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String stockName = request.getParameter("stockName");
        int stockQtt = Integer.parseInt(request.getParameter("stockQtt"));
        double stockPrice = Double.parseDouble(request.getParameter("stockPrice"));
        
        Stock newStock = new Stock(stockName, stockQtt, stockPrice);
        stockDAO.insertStock(newStock);
        response.sendRedirect("list");
    }
    
    private void updateStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int stockID = Integer.parseInt(request.getParameter("stockID"));
        String stockName = request.getParameter("stockName");
        int stockQtt = Integer.parseInt(request.getParameter("stockQtt"));
        double stockPrice = Double.parseDouble(request.getParameter("stockPrice"));

        Stock stock = new Stock(stockID, stockName, stockQtt, stockPrice);
        stockDAO.updateStock(stock);
        response.sendRedirect("list");
    }
    
    private void deleteStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int stockID = Integer.parseInt(request.getParameter("stockID"));
        stockDAO.deleteStock(stockID);
        response.sendRedirect("list");
    }
}
