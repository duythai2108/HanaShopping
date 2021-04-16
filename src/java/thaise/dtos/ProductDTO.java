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
public class ProductDTO {
     private String productID;
    private String productName;
    private String image;
    private String description;
    private float price;
    private int quantity;
    private Date createDate;
   
    private String status;
    private int cagID;
    private String nameCagt;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, String image, String description, float price, int quantity, Date createDate, String status, int cagID, String nameCagt) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
        this.status = status;
        this.cagID = cagID;
        this.nameCagt = nameCagt;
    }

    public ProductDTO(String productID, String productName, String image, String description, float price, int quantity, Date createDate, String status, int cagID) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
        this.status = status;
        this.cagID = cagID;
    }

    public ProductDTO(String productID, String productName, String image, float price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
         this.price = price;
        this.quantity = quantity;
    }

    public ProductDTO(String productID, String productName, String image, String description, float price, int quantity, Date createDate, String status) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
        this.status = status;
    }

    

   

 

   

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCagID() {
        return cagID;
    }

    public void setCagID(int cagID) {
        this.cagID = cagID;
    }

    public String getNameCagt() {
        return nameCagt;
    }

    public void setNameCagt(String nameCagt) {
        this.nameCagt = nameCagt;
    }

    
    
}
