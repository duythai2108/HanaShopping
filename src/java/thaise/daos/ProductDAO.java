/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import thaise.dtos.ProductDTO;
import thaise.utills.DBUtills;

/**
 *
 * @author duythai
 */
public class ProductDAO {

    public static final int ARTICLE_NUMER_OF_PAGE = 10;
    public static final String STATUS = "Active";
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<ProductDTO> getListProductByName(String search, int page_num) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        int count = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName , image, description, price,createDate,  p.catgID, c.nameCatg\n"
                        + "FROM tblProducts p JOIN tblCategories c\n"
                        + "	on p.catgID = c.catgID\n"
                        + "WHERE (productName like '%" + search + "%' OR c.nameCatg like '%" + search + "%')  AND status=? AND quantity > 0\n"
                        + "ORDER BY createDate DESC";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, STATUS);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    count++;
                    if (count >= (page_num - 1) * ARTICLE_NUMER_OF_PAGE + 1 && count <= page_num * ARTICLE_NUMER_OF_PAGE) {
                        String productID = rs.getString("productID");
                        String productName = rs.getString("productName");
                        String image = rs.getString("image");
                        String description = rs.getString("description");
                        float price = rs.getFloat("price");
                        Date createDate = rs.getDate("createDate");

                        String nameCatg = rs.getString("nameCatg");
                        int catgID = rs.getInt("catgID");

                        list.add(new ProductDTO(productID, productName, image, description, price, catgID, createDate, STATUS, catgID, nameCatg));
                        if (count == page_num * ARTICLE_NUMER_OF_PAGE) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<ProductDTO> getListProductByName() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        int count = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName , image, description, price,createDate,  p.catgID, c.nameCatg\n"
                        + "FROM tblProducts p JOIN tblCategories c\n"
                        + "	on p.catgID = c.catgID\n"
                        + "WHERE (productName like '%" + "" + "%' OR c.nameCatg like '%" + "" + "%')  AND status=? AND quantity > 0\n"
                        + "ORDER BY createDate DESC";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, STATUS);
                rs = pstm.executeQuery();
                while (rs.next()) {

                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    Date createDate = rs.getDate("createDate");

                    String nameCatg = rs.getString("nameCatg");
                    int catgID = rs.getInt("catgID");

                    list.add(new ProductDTO(productID, productName, image, description, price, catgID, createDate, STATUS, catgID, nameCatg));
//                        if (count == page_num * ARTICLE_NUMER_OF_PAGE) {
//                            break;
//                        }

                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<ProductDTO> getListProductRec(int catgID) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        int count = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName , image, description, price,createDate,  catgID\n"
                        + "FROM tblProducts \n"
                        + "WHERE status=? AND quantity > 0 AND catgID = ?\n"
                        + "ORDER BY createDate DESC";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, STATUS);
                pstm.setInt(2, catgID);
                rs = pstm.executeQuery();
                while (rs.next()) {

                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    Date createDate = rs.getDate("createDate");

                    list.add(new ProductDTO(productID, productName, image, description, price, catgID, createDate, STATUS, catgID));
//                        if (count == page_num * ARTICLE_NUMER_OF_PAGE) {
//                            break;
//                        }

                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ProductDTO getListProductID(String productID) throws SQLException {
        ProductDTO pDto = null;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT  productName, image, description, price,quantity,createDate "
                        + " FROM tblProducts "
                        + " WHERE productID=?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, productID);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    float price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    Date createDate = rs.getDate("createDate");

                    pDto = new ProductDTO(productID, productName, image, description, price, quantity, createDate, STATUS);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return pDto;
    }

    public List<ProductDTO> getListRangeMoney(int from, int to, int page_num) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        int count = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName , image, description, price,createDate,  p.catgID, c.nameCatg\n"
                        + "FROM tblProducts p JOIN tblCategories c\n"
                        + "	on p.catgID = c.catgID\n"
                        + "WHERE price BETWEEN " + from + " AND " + to + " AND status= ? AND quantity > 0 \n"
                        + "ORDER BY createDate DESC";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, STATUS);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    count++;
                    if (count >= (page_num - 1) * ARTICLE_NUMER_OF_PAGE + 1 && count <= page_num * ARTICLE_NUMER_OF_PAGE) {
                        String productID = rs.getString("productID");
                        String productName = rs.getString("productName");
                        String image = rs.getString("image");
                        String description = rs.getString("description");
                        int price = rs.getInt("price");

                        Date createDate = rs.getDate("createDate");

                        int catgID = rs.getInt("catgID");
                        String nameCatg = rs.getString("nameCatg");

                        list.add(new ProductDTO(productID, productName, image, description, price, catgID, createDate, STATUS, catgID, nameCatg));
                        if (count == page_num * ARTICLE_NUMER_OF_PAGE) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public int getCountNumberPage(String search) throws SQLException, ClassNotFoundException, NamingException {
        int count = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT p.productID "
                        + " FROM tblProducts p JOIN tblCategories c "
                        + "	on p.catgID = c.catgID "
                        + " WHERE productName like '%" + search + "%' OR c.nameCatg like '%" + search + "%'  AND status = ? AND quantity > 0";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, STATUS);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    count++;
                }
            }
        } finally {
            closeConnection();
        }
        return (int) Math.ceil((double) count / ARTICLE_NUMER_OF_PAGE);
    }

    public int getCountRangeMoney(int from, int to) throws SQLException, ClassNotFoundException, NamingException {
        int count = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT productID "
                        + " FROM tblProducts p  "
                        + " WHERE price BETWEEN " + from + " AND " + to + " AND status = ? AND quantity > 0";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, STATUS);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    count++;
                }
            }
        } finally {
            closeConnection();
        }
        return (int) Math.ceil((double) count / ARTICLE_NUMER_OF_PAGE);
    }

    public void createProduct(ProductDTO pDto) throws SQLException {
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblProducts(productID,productName,image,description,price,quantity,createDate,status,catgID) "
                        + " VALUES(?,?,?,?,?,?,?,?,?)";
                pstm = conn.prepareStatement(sql);

                pstm.setString(1, pDto.getProductID());
                pstm.setString(2, pDto.getProductName());
                pstm.setString(3, pDto.getImage());
                pstm.setString(4, pDto.getDescription());
                pstm.setFloat(5, pDto.getPrice());
                pstm.setInt(6, pDto.getQuantity());
                pstm.setDate(7, pDto.getCreateDate());

                pstm.setString(8, pDto.getStatus());
                pstm.setInt(9, pDto.getCagID());

                pstm.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
    }

    public void updateProduct(ProductDTO pDto) throws SQLException {
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblProducts SET "
                        + " productName=?, image=?,description=?, price=?, quantity=?, createDate=?, status=?,catgID=? "
                        + " WHERE productID=?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, pDto.getProductName());
                pstm.setString(2, pDto.getImage());
                pstm.setString(3, pDto.getDescription());
                pstm.setFloat(4, pDto.getPrice());

                pstm.setInt(5, pDto.getQuantity());
                pstm.setDate(6, pDto.getCreateDate());

                pstm.setString(7, pDto.getStatus());
                pstm.setInt(8, pDto.getCagID());
                pstm.setString(9, pDto.getProductID());

                pstm.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
    }

    public int getQuantity(String productID) throws SQLException {
        int result = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT quantity FROM tblProducts WHERE productID=?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, productID);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    result = rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return result;
    }

    public void updateQuantity(ProductDTO dto) throws SQLException, ClassNotFoundException, NamingException {
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = " UPDATE tblProducts SET quantity=? WHERE productID=? ";
                pstm = conn.prepareStatement(sql);

                pstm.setInt(1, dto.getQuantity());
                pstm.setString(2, dto.getProductID());

                pstm.executeUpdate();
            }
        } finally {
            closeConnection();
        }
    }
}
