/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

    public static void main(String[] args) {
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        nhanVienDAO.insert(new NhanVien("nv01", "Nguyễn Văn Tèo", "Hội An", "01688", "Trưởng Phòng"));

    }
}
