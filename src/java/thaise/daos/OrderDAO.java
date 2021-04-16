/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import thaise.dtos.OrderDTO;
import thaise.dtos.OrderDetailDTO;
import thaise.utills.DBUtills;

/**
 *
 * @author duythai
 */
public class OrderDAO {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
     public void insertOrder(OrderDTO odto) throws SQLException {
        try {
            conn = DBUtills.getConnection();
            String sql = "INSERT INTO tblOrders(userID,userName,AddressOrder,totalPrice,orderDate) "
                    + " VALUES(?,?,?,?,?) ";
            pst = conn.prepareStatement(sql);
            pst.setString(1, odto.getUserID());
            pst.setString(2, odto.getUserName());
            pst.setString(3, odto.getAddressOrder());
            pst.setFloat(4, odto.getTotalPrice());
            pst.setTimestamp(5, odto.getOrderDate());
            pst.executeUpdate();
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
    }
      public int getOrderID() throws SQLException {
        int orderID = 0;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = " SELECT Top(1) orderID "
                        + "FROM tblOrders "
                        + " ORDER BY orderID desc ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    orderID = rs.getInt("orderID");
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return orderID;
    }
       public void insertOrderDetail(OrderDetailDTO oddto) throws SQLException {
        try {
            conn = DBUtills.getConnection();
            String sql = "INSERT INTO tblOrderDetails(orderID,productID,quantity,price)"
                    + " VALUES(?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, oddto.getOrderID());
            pst.setString(2, oddto.getProductID());
            
            pst.setInt(3, oddto.getQuantity());
            pst.setFloat(4, oddto.getPrice());
            pst.executeUpdate();
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
    }
}
