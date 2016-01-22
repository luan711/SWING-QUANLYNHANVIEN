/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.NhanVien;
import model.User;

/**
 *
 * @author Admin
 */
public class NhanVienDAO {

    Connection connect;
    String dbName;
    String url;

    public NhanVienDAO() {
        dbName = "quanly";
        url = "jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName=" + dbName;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url, "sa", "123456");
            System.out.println("Connect successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Chèn mới nhân viên vào Database
    public int insert(NhanVien nv) {
        int result = 0;
        try {
            Statement st = connect.createStatement();
            result = st.executeUpdate("insert into nhanVien values ('" + nv.getManhanvien()
                    + "',N'" + nv.getHoten()
                    + "',N'" + nv.getDiachi()
                    + "','" + nv.getDienthoai()
                    + "',N'" + nv.getChucvu()
                    + "')");
        } catch (Exception e) {

            e.printStackTrace();
        }
        return result;
    }

    // Sửa thông tin nhân viên
    public int update(NhanVien nhanVien) {
        int result = 0;
        try {
            PreparedStatement ps = connect.prepareStatement("update nhanVien set hoten =?, diachi=?, dienthoai=?, chucvu=? where manhanvien=?");
            ps.setString(1, nhanVien.getHoten());
            ps.setString(2, nhanVien.getDiachi());
            ps.setString(3, nhanVien.getDienthoai());
            ps.setString(4, nhanVien.getChucvu());
            ps.setString(5, nhanVien.getManhanvien());

            result = ps.executeUpdate();// so hang bi thay doi tu cau lenh sql
        } catch (Exception ex) {
            System.out.println("Error SQL");
        }
        return result;
    }

    // Lấy ra 1 Nhân viên trong Database
    public NhanVien getNhanVien(String manhanvien) {
        
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("Select * from nhanVien where manhanvien='" + manhanvien + "'");
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setManhanvien(rs.getString(1));
                nhanVien.setHoten(rs.getString(2));
                nhanVien.setDiachi(rs.getString(3));
                nhanVien.setDienthoai(rs.getString(4));
                nhanVien.setChucvu(rs.getString(5));

                return nhanVien;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy List Nhân viên trong Database
    public ArrayList<NhanVien> getAllListNhanVien() {
        ArrayList<NhanVien> result = new ArrayList<>();
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("Select * from nhanVien");
            while (rs.next()) {
                NhanVien row = new NhanVien();
                row.setManhanvien(rs.getString(1));
                row.setHoten(rs.getString(2));
                row.setDiachi(rs.getString(3));
                row.setDienthoai(rs.getString(4));
                row.setChucvu(rs.getString(5));

                result.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Xóa nhân viên
    public int delete(String manhanvien) {
        int result = 0;
        try {
            PreparedStatement ps = connect.prepareStatement("delete from nhanVien where manhanvien=?");
            ps.setString(1, manhanvien);

            result = ps.executeUpdate();// so hang bi thay doi tu cau lenh sql
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error SQL");
        }
        return result;
    }

    public static void main(String[] args) {
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        //nhanVienDAO.insert(new NhanVien("nv01", "Nguyễn Văn Tèo", "Hội An", "01688", "Trưởng Phòng"));
        System.out.println(nhanVienDAO.getAllListNhanVien());

    }
}
