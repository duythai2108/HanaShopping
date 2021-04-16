/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thaise.dtos.CartDTO;
import thaise.dtos.ProductDTO;

/**
 *
 * @author duythai
 */
public class AddCartController extends HttpServlet {
    private static final String SUCCESS = "MainController?btnAction=Search&txtSearch=";
    private static final String ERROR = "MainController?btnAction=Search&txtSearch=";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String productID = request.getParameter("txtProductID");
            String productName = request.getParameter("txtProductName");
            String image = request.getParameter("txtImage");
            float price = Float.valueOf(request.getParameter("txtPrice"));
            int quantity = 0;
            ProductDTO pdto = new ProductDTO(productID, productName, image, price, quantity);
             HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");

            if (cart == null) {
                cart = new CartDTO(null);
            }
            cart.add(pdto);
            int cartcount = cart.getCart().keySet().size();
            session.setAttribute("CART", cart);
            session.setAttribute("CARTCOUNT", cartcount);
            url = SUCCESS;
            request.setAttribute("messageCart", "Item "+ productName+ " added to cart!");
        } catch (Exception e) {
             Logger.getLogger(AddCartController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
           request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
