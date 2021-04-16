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
public class ProductErrorDTO {
     private String productIDError;
    private String productNameError;
    private String imageError;
    private String descriptionError;
    private int priceError;
    private int quantityError;
    private Timestamp createDateError;
    
    private String statusError;
    private int cagIDError;
    private String nameCagtError;

    public ProductErrorDTO() {
    }

    public ProductErrorDTO(String productIDError, String productNameError, String imageError, String descriptionError, int priceError, int quantityError, Timestamp createDateError, String statusError, int cagIDError, String nameCagtError) {
        this.productIDError = productIDError;
        this.productNameError = productNameError;
        this.imageError = imageError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.createDateError = createDateError;
        this.statusError = statusError;
        this.cagIDError = cagIDError;
        this.nameCagtError = nameCagtError;
    }

    public String getProductIDError() {
        return productIDError;
    }

    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    public String getProductNameError() {
        return productNameError;
    }

    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public int getPriceError() {
        return priceError;
    }

    public void setPriceError(int priceError) {
        this.priceError = priceError;
    }

    public int getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(int quantityError) {
        this.quantityError = quantityError;
    }

    public Timestamp getCreateDateError() {
        return createDateError;
    }

    public void setCreateDateError(Timestamp createDateError) {
        this.createDateError = createDateError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public int getCagIDError() {
        return cagIDError;
    }

    public void setCagIDError(int cagIDError) {
        this.cagIDError = cagIDError;
    }

    public String getNameCagtError() {
        return nameCagtError;
    }

    public void setNameCagtError(String nameCagtError) {
        this.nameCagtError = nameCagtError;
    }
    
}
