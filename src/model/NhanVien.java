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
public class NhanVien {
    private String manhanvien;
    private String hoten;
    private String diachi;
    private String dienthoai;
    private String chucvu;

    public NhanVien() {
    }

    public NhanVien(String manhanvien, String hoten, String diachi, String dienthoai, String chucvu) {
        this.manhanvien = manhanvien;
        this.hoten = hoten;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.chucvu = chucvu;
    }

    
    
    
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    
    
}
