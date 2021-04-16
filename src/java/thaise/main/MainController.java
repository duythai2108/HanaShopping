/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duythai
 */
public class MainController extends HttpServlet {
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    
    private static final String ERROR = "invalid.html";
    public static final String SEARCH = "SearchController";
    public static final String SEARCH_PRICE = "SearchPriceController";
    public static final String SEARCH_CATE = "SearchController";
    public static final String CREATE_PRODUCT = "CreateProductController";
    public static final String CREATE_PRODUCT_FORM = "CreateProductFormController";
    public static final String UPDATE_PRODUCT = "UpdateProductController";
    public static final String UPDATE_PRODUCT_FORM = "UpdateProductFormController";
    public static final String ADD_CART = "AddCartController";
    public static final String VIEW_CART = "cart.jsp";
    public static final String UPDATE_CART = "UpdateCartController";
    public static final String DELETE_CART = "DeleteCartController";
    public static final String CHECKOUT = "CheckoutController";
    public static final String HISTORY = "HistoryController";
    public static final String DETAIL = "DetailController";
    public static final String SEARCH_HISTORY = "SearchHistoryController";
    public static final String SEARCH_HISTORY_DATE = "SearchHistoryByDateController";
    
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
            String action =  request.getParameter("btnAction");
            if("Login".equals(action)){
                url = LOGIN;
            }else if ("Logout".equals(action)) {
                url = LOGOUT;
            }
            else if ("Search".equals(action)) {
                url = SEARCH;
            }else if ("Search Price".equals(action)) {
                url = SEARCH_PRICE;
            }else if ("Search Category".equals(action)) {
                url = SEARCH_CATE;
            }else if ("Create Product".equals(action)) {
                url = CREATE_PRODUCT;
            }else if ("Create Product Form".equals(action)) {
                url = CREATE_PRODUCT_FORM;
             } else if ("Update Product".equals(action)) {
                url = UPDATE_PRODUCT;
            } else if ("Update Product Form".equals(action)) {
                url = UPDATE_PRODUCT_FORM;
            }else if ("Add Cart".equals(action)) {
                url = ADD_CART;
            }else if ("View Cart".equals(action)) {
                url = VIEW_CART;
            }else if ("UpdateCart".equals(action)) {
                url = UPDATE_CART;
            }else if ("DeleteCart".equals(action)) {
                url = DELETE_CART;
            }else if ("CheckOut".equals(action)) {
                url = CHECKOUT;
            }else if ("History".equals(action)) {
                url = HISTORY;
            }else if ("Detail".equals(action)) {
                url = DETAIL;
            }else if ("SearchHistory".equals(action)) {
                url = SEARCH_HISTORY;
            }else if ("SearchHistoryByDate".equals(action)) {
                url = SEARCH_HISTORY_DATE;
            }
            
        } catch (Exception e) {
        }finally{
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
