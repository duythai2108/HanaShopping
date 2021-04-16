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
import thaise.dtos.HistoryDTO;
import thaise.utills.DBUtills;

/**
 *
 * @author duythai
 */
public class HistoryDAO {

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

    public List<HistoryDTO> getListHistoryByUserID(String userID) throws SQLException {
        List<HistoryDTO> list = new ArrayList<>();
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT p.productName,p.image,o.orderDate,d.quantity,d.price\n"
                        + "FROM tblOrders o,tblOrderDetails d,tblProducts p\n"
                        + "WHERE o.orderID=d.orderID AND d.productID=p.productID AND o.userID = ? ";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userID);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    Date orderDate = rs.getDate("orderDate");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    list.add(new HistoryDTO(productName, image, quantity, price, price, userID, orderDate));
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<HistoryDTO> getListHistoryByName(String userID, String search) throws SQLException {
        List<HistoryDTO> list = new ArrayList<>();
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT p.productName,p.image,o.orderDate,d.quantity,d.price\n"
                        + "FROM tblOrders o,tblOrderDetails d,tblProducts p\n"
                        + "WHERE o.orderID=d.orderID AND d.productID=p.productID AND  p.productName like '%" + search + "%' AND o.userID = ?  ";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userID);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String productName = rs.getString("productName");

                    String image = rs.getString("image");
                    Date orderDate = rs.getDate("orderDate");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    list.add(new HistoryDTO(productName, image, quantity, price, price, userID, orderDate));
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return list;
    }

}
