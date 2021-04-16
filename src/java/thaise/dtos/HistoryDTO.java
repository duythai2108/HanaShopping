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
public class HistoryDTO {
    private String productName;
    private String image;
    private int quantity;
    private float price;
    private float totalPrice;
    private String userID;
    private Date orderDate;
    public HistoryDTO() {
    }

    public HistoryDTO(String productName, String image, int quantity, float price, float totalPrice, String userID, Date orderDate) {
        this.productName = productName;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.userID = userID;
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

   
    
}
