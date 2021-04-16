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
import java.util.logging.Level;
import java.util.logging.Logger;
import thaise.dtos.UserDTO;
import thaise.utills.DBUtills;

/**
 *
 * @author duythai
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO result = null;
        try {
            conn = DBUtills.getConnection();
            String url = "SELECT userName,roleID\n"
                    + "FROM tblUsers\n"
                    + "WHERE userID = ? AND password = ? AND status = 1";
            stm = conn.prepareStatement(url);
            stm.setString(1, userID);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if(rs.next()){
                result = new UserDTO(userID, rs.getString("userName"), password, 0, "", true, rs.getString("roleID"));
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }
    public UserDTO checkUserID(String userID) throws SQLException {
        UserDTO user = null;
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT userID,name\n"
                        + "FROM tblUsers\n"
                        + "WHERE userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                while(rs.next()){
                    user = new UserDTO(userID,  rs.getString("name"),"", 0, "", true,"");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return user;
    }
    public void registerAccount(UserDTO user) throws SQLException{
        try {
            conn=DBUtills.getConnection();
            if(conn!= null){
                String sql = "INSERT INTO tblUsers(userID,userName,password,phone,address,status,roleID) "
                            +" VALUES(?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getUserName());
                stm.setString(3, user.getPassword());
                stm.setInt(4, user.getPhone());
                stm.setString(5, user.getAddress());
                stm.setBoolean(6, true);
                stm.setString(7, user.getRoleID());
                stm.executeUpdate();
            }
            
        } catch (Exception e) {
            
        }finally{
            closeConnection();
        }
    }
}
