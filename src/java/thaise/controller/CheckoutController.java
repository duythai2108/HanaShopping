/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thaise.daos.OrderDAO;
import thaise.daos.ProductDAO;
import thaise.daos.UserDAO;
import thaise.dtos.CartDTO;
import thaise.dtos.OrderDTO;
import thaise.dtos.OrderDetailDTO;
import thaise.dtos.ProductDTO;
import thaise.dtos.SendingEmail;
import thaise.dtos.UserDTO;

/**
 *
 * @author duythai
 */
public class CheckoutController extends HttpServlet {

    public static final String SUCCESS = "success.jsp";
    public static final String ERROR = "information.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws javax.naming.NamingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            List<String> quantityError = new ArrayList<>();
            String userID = request.getParameter("txtEmail");
            String name = request.getParameter("txtName");
            String address = request.getParameter("txtAddress");
            Timestamp orderDate = Timestamp.valueOf(LocalDateTime.now());
            int total = 0;
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
                UserDAO udao = new UserDAO();
                UserDTO udto = udao.checkUserID(userID);
                if (udto == null && !userID.equals("")) {
                    udto = new UserDTO(userID, name, "", 0, address, true, "US");
                    udao.registerAccount(udto);
                }
            }
            OrderDAO odao = new OrderDAO();
            ProductDAO pdao = new ProductDAO();
            OrderDTO odto;

            for (ProductDTO pDto : cart.getCart().values()) {
                int quantity = pdao.getQuantity(pDto.getProductID());
                if (pDto.getQuantity() > quantity) {
                    quantityError.add("Product " + pDto.getProductName() + " does not remain enough. Avaiable quantity: " + quantity);
                } else {
                    total += pDto.getPrice() * pDto.getQuantity();
                }
            }
            if (quantityError.isEmpty()) {
                odto = new OrderDTO(userID, name, address, total, orderDate);
                odao.insertOrder(odto);
                OrderDetailDTO oddto;

                int orderID = odao.getOrderID();
                for (ProductDTO pDto : cart.getCart().values()) {
                    int quantity = pdao.getQuantity(pDto.getProductID());
                    oddto = new OrderDetailDTO(orderID, pDto.getProductID(), cart.getCart().get(pDto.getProductID()).getQuantity(), pDto.getPrice());
                    odao.insertOrderDetail(oddto);
                    pDto.setQuantity(quantity - pDto.getQuantity());
                    pdao.updateQuantity(pDto);
                       
                }
                SendingEmail se = new SendingEmail(userID);
                se.sendEmail();
                url = SUCCESS;
                cart.removeAll();
            } else {
                request.setAttribute("QUANTITY_ERROR", quantityError);
            }
        } catch (Exception e) {

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
