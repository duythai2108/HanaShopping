/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaise.dtos;

/**
 *
 * @author duythai
 */
public class UserDTO {
    private String userID;
    private String userName;
    private String password;
    private int phone;
    private String address;
    private boolean status;
    private String roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String password, int phone, String address, boolean status, String roleID) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.roleID = roleID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
    
}
