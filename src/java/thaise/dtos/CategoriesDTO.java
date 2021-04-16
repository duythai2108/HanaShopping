/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.dtos;

import java.io.Serializable;

/**
 *
 * @author duythai
 */
public class CategoriesDTO implements Serializable{
     private String nameCateg;
    private int cateID;

    public CategoriesDTO() {
    }

    public CategoriesDTO(String nameCateg, int cateID) {
        this.nameCateg = nameCateg;
        this.cateID = cateID;
    }

    public String getNameCateg() {
        return nameCateg;
    }

    public void setNameCateg(String nameCateg) {
        this.nameCateg = nameCateg;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }
}
