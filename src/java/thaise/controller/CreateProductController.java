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
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import thaise.daos.ProductDAO;
import thaise.dtos.ProductDTO;
import thaise.dtos.ProductErrorDTO;

/**
 *
 * @author duythai
 */
public class CreateProductController extends HttpServlet {

    public static final String SUCCESS = "addproduct.jsp";
    public static final String ERROR = "addproduct.jsp";
    public static final String STATUS = "ACTIVE";
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
        PrintWriter out = response.getWriter();
        String url = ERROR;
        ProductErrorDTO pe = new ProductErrorDTO();
        try {
            String productID = request.getParameter("txtProductID");
            String productName = request.getParameter("txtProductName");
            String image = request.getParameter("txtImage");
            String description = request.getParameter("txtDescription");
            float price = Float.valueOf(request.getParameter("txtPrice"));
            int quantity = Integer.valueOf(request.getParameter("txtQuantity"));
            Date createDate = Date.valueOf(request.getParameter("txtCreateDate"));
            Calendar cal = Calendar.getInstance();
            cal.setTime(createDate);
            cal.add(Calendar.MONTH, 6);

            int catgID = Integer.parseInt(request.getParameter("txtCate"));
            boolean flag = true;

            

            // Đường dẫn tuyệt đối tới thư mục gốc của web app.
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
            //nek no chay toi day xong khong chay xuong lay cai real path duoc :((
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
            ProductDAO dao = new ProductDAO();
            if (flag) {
                ProductDTO dto = new ProductDTO(productID, productName, image, description, price, quantity, createDate, STATUS, catgID, image);
                dao.createProduct(dto);
                url = SUCCESS;
                request.setAttribute("messageProduct", "Create product successfully!!!");
            } else {
                request.setAttribute("PRODUCT_ERROR", pe);
            }

        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                pe.setProductIDError("ID is existed");
                request.setAttribute("PRODUCT_ERROR", pe);
            }
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
