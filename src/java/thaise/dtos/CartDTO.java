/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author duythai
 */
public class CartDTO implements Serializable {

    private Map<String, ProductDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public void add(ProductDTO dto) {
        if (this.cart == null) {
            cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getProductID())) {
            int quantity = this.cart.get(dto.getProductID()).getQuantity();
            dto.setQuantity(quantity + 1);
        } else {
            dto.setQuantity(1);
        }
        cart.put(dto.getProductID(), dto);
    }

    public void remove(String id) {

        if (cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void update(String id, ProductDTO dto) {
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                
                this.cart.replace(id, dto);
            }
        }
    }
    public void removeAll(){
        if(cart.size()>0){
            cart.clear();
        }
    }

}
