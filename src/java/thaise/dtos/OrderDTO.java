/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.dtos;

import java.sql.Timestamp;

/**
 *
 * @author duythai
 */
public class OrderDTO {
     private String userID;
    private String userName;
    private String AddressOrder;
    private float totalPrice;
    private Timestamp orderDate;

    public OrderDTO() {
    }

    public OrderDTO(String userID, String userName, String AddressOrder, float totalPrice, Timestamp orderDate) {
        this.userID = userID;
        this.userName = userName;
        this.AddressOrder = AddressOrder;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddressOrder() {
        return AddressOrder;
    }

    public void setAddressOrder(String AddressOrder) {
        this.AddressOrder = AddressOrder;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
       
   
}
