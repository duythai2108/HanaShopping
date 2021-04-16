/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import thaise.daos.CategoriesDAO;
import thaise.daos.ProductDAO;
import thaise.daos.RecordDAO;

import thaise.dtos.ProductDTO;
import thaise.dtos.ProductErrorDTO;
import thaise.dtos.RecordDTO;
import thaise.dtos.UserDTO;

/**
 *
 * @author duythai
 */
public class UpdateProductController extends HttpServlet {

    public static final String SUCCESS = "update.jsp";
    public static final String ERROR = "update.jsp";
    public static final String SAVE_DIRECTORY = "img/";
    public static final String SAVE_DIRECTORY1 = "product";

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
        ProductErrorDTO pe = new ProductErrorDTO();
        try {
            String productID = request.getParameter("txtProductID");
            String productName = request.getParameter("txtProductName");
            String image = request.getParameter("txtImages");
            String description = request.getParameter("txtDescription");
            float price = Float.valueOf(request.getParameter("txtPrice"));
            int quantity = Integer.valueOf(request.getParameter("txtQuantity"));
            Date curDate = Date.valueOf(LocalDate.now());
            Date createDate = Date.valueOf(request.getParameter("txtCreateDate"));
            Calendar cal = Calendar.getInstance();
            cal.setTime(createDate);
            cal.add(Calendar.MONTH, 6);

            String status = request.getParameter("txtStatus");
            int catgID = Integer.parseInt(request.getParameter("txtCagID"));
            boolean flag = true;

            if (price < 0) {
                pe.setPriceError(1);
                flag = false;
            }

            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');
            String s1 = appPath.substring(0, appPath.length() - 11);
            String s2 = s1 + "/web";

            // Thư mục để save file tải lên.
            String fullSavePath = null;
            if (s2.endsWith("/")) {
                fullSavePath = s2 + SAVE_DIRECTORY + SAVE_DIRECTORY1;
            } else {
                fullSavePath = s2 + "/" + SAVE_DIRECTORY + SAVE_DIRECTORY1;
            }

            // Tạo thư mục nếu nó không tồn tại.
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            // Danh mục các phần đã upload lên (Có thể là nhiều file).
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    image = fileName;
                    String image_db = fullSavePath + File.separator + fileName;

                    // Ghi vào file.
                    part.write(image_db);
                }
            }
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            String userID = user.getUserID();
            ProductDAO dao = new ProductDAO();
//            CategoriesDAO rdao = new CategoriesDAO();
            RecordDAO rdao = new RecordDAO();
            if (flag) {
                ProductDTO dto = new ProductDTO(productID, productName, image, description, price, quantity, createDate, status, catgID);
                dao.updateProduct(dto);
                PrintWriter out = response.getWriter();
                out.append(productID + "'");
                RecordDTO rdto = new RecordDTO(productID, userID, curDate);
                rdao.addRecord(rdto);
                url = SUCCESS;
                request.setAttribute("messageUpdate", "Update product successfully!!!");
            } else {
                request.setAttribute("PRODUCT_ERROR", pe);
            }
        } catch (Exception e) {
            Logger.getLogger(UpdateProductController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                if (clientFileName.equals("")) {
                    return null;
                } else {
                    clientFileName = clientFileName.replace("\\", "/");
                    String s3 = clientFileName.substring(clientFileName.indexOf("."), clientFileName.length());
                    clientFileName = System.currentTimeMillis() + s3;
                    int i = clientFileName.lastIndexOf('/');
                    // file1.zip
                    // file2.zip
                    return clientFileName.substring(i + 1);
                }
            }
        }
        return null;
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
