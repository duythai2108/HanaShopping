/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.dtos;

import java.sql.Date;



/**
 *
 * @author duythai
 */
public class RecordDTO {
    private String productID;
    private String userID;
    private Date date;

    public RecordDTO() {
    }

    public RecordDTO(String productID, String userID, Date date) {
        this.productID = productID;
        this.userID = userID;
        this.date = date;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
