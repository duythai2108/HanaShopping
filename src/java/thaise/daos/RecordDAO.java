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
import thaise.dtos.RecordDTO;
import thaise.utills.DBUtills;

/**
 *
 * @author duythai
 */
public class RecordDAO {

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

    public void addRecord(RecordDTO dto) throws SQLException {
        try {
            conn = DBUtills.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUpdateRecord(userID, productID,date) "
                        + " VALUES(?,?,?)";
                pstm = conn.prepareStatement(sql);

                pstm.setString(1, dto.getUserID());
                pstm.setString(2, dto.getProductID());
                pstm.setDate(3, dto.getDate());

                pstm.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
