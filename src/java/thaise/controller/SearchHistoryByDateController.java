/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thaise.daos.HistoryDAO;
import thaise.dtos.HistoryDTO;
import thaise.dtos.ProductDTO;
import thaise.dtos.UserDTO;

/**
 *
 * @author duythai
 */
public class SearchHistoryByDateController extends HttpServlet {
        private static final String SUCCESS = "history.jsp";
        private static final String ERROR = "shoping.jsp";
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
            String dateHis = request.getParameter("dateHis");
             HttpSession session = request.getSession();
            UserDTO userDTO = (UserDTO) session.getAttribute("LOGIN_USER");
            HistoryDAO historyDAO = new HistoryDAO();
          
           List<HistoryDTO> historyList = historyDAO.getListHistoryByUserID(userDTO.getUserID());
//          String orderdate =  historyList.get(0).getOrderDate().toString();
//          
//          if(dateHis.equals(orderdate)){
//              session.setAttribute("LIST_HISTORY", historyList);
//            url = SUCCESS;
//          }
//           for(int i = 0 ; i < historyList.size();i++){
//              Date orderDate = historyList.get(i).getOrderDate();
//              if(dateHis.compareTo(orderDate)>0){
//                   url = ERROR;
//                   break;
//              }else if(dateHis.compareTo(orderDate)<0){
//                  
//                  url = ERROR;
//                  break;
//              }else{
//                   session.setAttribute("LIST_HISTORY", historyList);
//            url = SUCCESS;
//            break;
//              }
//              
//           }
//            for(int i = 0; i < historyList.size(); i++){
//                String orderDate = historyList.get(i).getOrderDate().toString();
//                if(dateHis.contains(orderDate)){
//                   
//                    
//                }
//            }
                List temp = new ArrayList<>();
            for (HistoryDTO historyDTO : historyList) {
                if(dateHis.contains(historyDTO.getOrderDate().toString())){
                    temp.add(historyDTO);
                    
                };
            }
          
             session.setAttribute("LIST_HISTORY", temp);
                    url = SUCCESS;
            
        }
        catch (Exception e) {
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
