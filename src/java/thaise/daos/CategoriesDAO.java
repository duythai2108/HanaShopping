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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thaise.dtos.CategoriesDTO;
import thaise.dtos.RecordDTO;
import thaise.utills.DBUtills;

/**
 *
 * @author duythai
 */
public class CategoriesDAO {
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
    public List<CategoriesDTO> getListCateg(String search, int page_num) throws SQLException {
        List<CategoriesDTO> list = new ArrayList<>();

        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT catgID, nameCatg\n"
                        + "FROM tblCategories";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int catgID = rs.getInt("catgID");
                    String nameCateg = rs.getString("nameCatg");

                    list.add(new CategoriesDTO(nameCateg, catgID));

                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<CategoriesDTO> getListCateg() throws SQLException {
        List<CategoriesDTO> list = new ArrayList<>();

        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "SELECT catgID, nameCatg\n"
                        + "FROM tblCategories";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int catgID = rs.getInt("catgID");
                    String nameCateg = rs.getString("nameCatg");

                    list.add(new CategoriesDTO(nameCateg, catgID));

                }
            }
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return list;
    }
//    public void addRecord(RecordDTO rDto) throws SQLException{
//        try {
//             conn= DBUtills.getConnection();
//            if(conn != null){
//              String sql = "INSERT INTO tblUpdateRecord(userID, productID, date ) "
//                      + " VALUES(?,?,?) ";
//              pstm = conn.prepareStatement(sql);
//              pstm.setString(1, rDto.getUserID());
//              pstm.setString(2, rDto.getProductID());
//              pstm.setDate(3, rDto.getDate());
//              pstm.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            closeConnection();
//        }
//    }
    
}
