/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;
import sun.security.x509.AlgorithmId;

/**
 *
 * @author Admin
 */
public class UserDAO {

    Connection connect;
    String dbName;
    String url;

    public UserDAO() {
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

    // Phương thức thêm thành viên vào bảng
    public int insert(User user) {
        int result = 0;
        try {
            Statement st = connect.createStatement();
            result = st.executeUpdate("insert into Users values ('" + user.getUser_()
                    + "','" + md5(user.getPass())
                    + "','" + user.getRole_()
                    + "','" + user.getManhanvien()
                    + "')");
        } catch (Exception e) {

            e.printStackTrace();
        }
        return result;
    }

    // Phương thức kiểm tra login hợp lệ
    public boolean checkLogin(String username, String password) {
        try {
            PreparedStatement ps = connect.prepareStatement("select * from Users where user_ = '" + username + "' and pass = '" + md5(password) + "'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ // ton tai username
                return true;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức xóa User
    // Xóa nhân viên
    public int delete(String manhanvien) {
        int result = 0;
        try {
            PreparedStatement ps = connect.prepareStatement("delete from Users where manhanvien=?");
            ps.setString(1, manhanvien);

            result = ps.executeUpdate();// so hang bi thay doi tu cau lenh sql
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error SQL");
        }
        return result;
    }
    
    
    // Mã hóa MD5 Password
    private String md5(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        //udao.insert(new User("admin", udao.md5("123456"), "admin", "nv01"));
        System.out.println(udao.checkLogin("abcabc5803", "123456"));
    }

}
