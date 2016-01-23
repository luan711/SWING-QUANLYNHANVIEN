/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
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

    // Demo JDBCRowSet
    public boolean insert(User user) {
        try {
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from Users");
            JdbcRowSet rowSet = new JdbcRowSetImpl(rs); // đổ kết quả từ ResultSet vào bộ nhớ tạm
            rowSet.moveToInsertRow();
            rowSet.updateString(1, user.getUser_());
            rowSet.updateString(2, md5(user.getPass()));
            rowSet.updateString(3, user.getRole_());
            rowSet.updateString(4, user.getManhanvien());
            
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
            return true;
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
    }

    // demo CacheRowSet
    public boolean editPassword(String username, String password) {
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            crs.setUsername("sa");
            crs.setPassword("123456");
            crs.setUrl(url);
            crs.setCommand("select * from Users");
            crs.execute();// do ra bo nho tam
            while (crs.next()) {
                if (crs.getString(1).equals(username)) {
                    crs.updateString(2, md5(password));
                    
                    crs.updateRow();
                    
                }
            }
            crs.acceptChanges();
            return true;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    // Phương thức kiểm tra login hợp lệ
    public boolean checkLogin(String username, String password) {
        try {
            PreparedStatement ps = connect.prepareStatement("select * from Users where user_ = '" + username + "' and pass = '" + md5(password) + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // ton tai username
                return true;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Kiem tra su ton tai cua username
    public boolean checkExistUsername(String username) {
        try {
            PreparedStatement ps = connect.prepareStatement("select * from Users where user_ = '" + username + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // ton tai ma nhan vien trong he thong
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
//        System.out.println(udao.checkLogin("abcabc5803", "123456"));
        System.out.println(udao.editPassword("admin", "1234567"));
    }
    
}
