/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thaise.daos.CategoriesDAO;
import thaise.daos.ProductDAO;
import thaise.dtos.CategoriesDTO;
import thaise.dtos.ProductDTO;

/**
 *
 * @author duythai
 */
public class SearchController extends HttpServlet {

    public static final String SUCCESS = "shoping.jsp";
    public static final String ERROR = "shoping.jsp";

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
        boolean error = false;
        boolean NoRecord = false;
        try {
            String search = request.getParameter("txtSearch");
            String curPageStr = request.getParameter("txtCurPage");
            int curpage;
            if (curPageStr == null || curPageStr.isEmpty()) {
                curpage = 1;
            } else {
                curpage = Integer.parseInt(curPageStr);
            }
            ProductDAO dao = new ProductDAO();
            int pageNum = dao.getCountNumberPage(search);
            if (pageNum == 0) {
                NoRecord = true;
            } else if (curpage > pageNum || curpage < 1) {
                error = true;
            }
       
//            if (!error && !NoRecord) {
//                HttpSession session = request.getSession();
            if (search == null) {
                List<ProductDTO> list = dao.getListProductByName();
                CategoriesDAO cateDao = new CategoriesDAO();
                List<CategoriesDTO> listCate = cateDao.getListCateg();

                request.setAttribute("CUR_PAGE", curpage);
                request.setAttribute("PAGE_NUMBER", pageNum);
                request.setAttribute("LIST_PRODUCT", list);
                request.setAttribute("LIST_CATE", listCate);
            } else {
                List<ProductDTO> list = dao.getListProductByName(search, curpage);
                CategoriesDAO cateDao = new CategoriesDAO();
                List<CategoriesDTO> listCate = cateDao.getListCateg(search, curpage);

                request.setAttribute("CUR_PAGE", curpage);
                request.setAttribute("PAGE_NUMBER", pageNum);
                request.setAttribute("LIST_PRODUCT", list);
                request.setAttribute("LIST_CATE", listCate);
            }

            url = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
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
