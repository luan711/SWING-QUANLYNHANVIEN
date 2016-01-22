/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class User {
    private String user_;
    private String pass;
    private String role_;
    private String manhanvien;

    public User() {
    }

    public User(String user_, String pass, String role_, String manhanvien) {
        this.user_ = user_;
        this.pass = pass;
        this.role_ = role_;
        this.manhanvien = manhanvien;
    }

    public String getUser_() {
        return user_;
    }

    public void setUser_(String user_) {
        this.user_ = user_;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole_() {
        return role_;
    }

    public void setRole_(String role_) {
        this.role_ = role_;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }
    
    
    
}
