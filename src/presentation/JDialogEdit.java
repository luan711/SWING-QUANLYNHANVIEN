/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import dao.NhanVienDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class JDialogEdit extends javax.swing.JDialog {

    NhanVienDAO nhanVienDAO;

    /**
     * Creates new form JDialogEdit
     */
    public JDialogEdit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        nhanVienDAO = new NhanVienDAO();
        bindJComboBox();
    }

    /**
     * Các phương thức riêng
     */
    ///////////////////////////////////////////////////////////////
    private void bindJComboBox() {
        ArrayList<NhanVien> result = new ArrayList<>();
        result = nhanVienDAO.getAllListNhanVien();
        for (NhanVien nv : result) {
            jComboBoxMaNV.addItem(nv.getManhanvien());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxMaNV = new javax.swing.JComboBox<>();
        jTextFieldHoTen = new javax.swing.JTextField();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jTextFieldDienThoai = new javax.swing.JTextField();
        jComboBoxChucVu = new javax.swing.JComboBox<>();
        jButtonChinhSua = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Chỉnh sửa dữ liệu");

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Họ tên");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("Điện thoại");

        jLabel6.setText("Chức vụ");

        jComboBoxMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaNVActionPerformed(evt);
            }
        });
        jComboBoxMaNV.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxMaNVPropertyChange(evt);
            }
        });

        jComboBoxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Trường phòng", "Phó Giám đốc", "Giám đốc" }));

        jButtonChinhSua.setText("Chỉnh sửa");
        jButtonChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChinhSuaActionPerformed(evt);
            }
        });

        jButtonThoat.setText("Thoát");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxMaNV, 0, 185, Short.MAX_VALUE)
                            .addComponent(jTextFieldHoTen)
                            .addComponent(jTextFieldDiaChi)
                            .addComponent(jTextFieldDienThoai)
                            .addComponent(jComboBoxChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButtonChinhSua)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonThoat)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChinhSua)
                    .addComponent(jButtonThoat))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChinhSuaActionPerformed
        // TODO add your handling code here:
        String manhanvien = (String) jComboBoxMaNV.getSelectedItem();
        String hoten = jTextFieldHoTen.getText();
        String diachi = jTextFieldDiaChi.getText();
        String dienthoai = jTextFieldDienThoai.getText();
        String chucvu = (String) jComboBoxChucVu.getSelectedItem();

        NhanVien nhanVien = new NhanVien(manhanvien, hoten, diachi, dienthoai, chucvu);
        if (nhanVienDAO.update(nhanVien) > 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật dữ liệu, xem lại các kết nối");
        }

    }//GEN-LAST:event_jButtonChinhSuaActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jComboBoxMaNVPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxMaNVPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxMaNVPropertyChange

    private void jComboBoxMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaNVActionPerformed
        // TODO add your handling code here:
        String manhanvien = (String) jComboBoxMaNV.getSelectedItem();
        jTextFieldHoTen.setText(nhanVienDAO.getNhanVien(manhanvien).getHoten());
        jTextFieldDiaChi.setText(nhanVienDAO.getNhanVien(manhanvien).getDiachi());
        jTextFieldDienThoai.setText(nhanVienDAO.getNhanVien(manhanvien).getDienthoai());
    }//GEN-LAST:event_jComboBoxMaNVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogEdit dialog = new JDialogEdit(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChinhSua;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JComboBox<String> jComboBoxChucVu;
    private javax.swing.JComboBox<String> jComboBoxMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldDienThoai;
    private javax.swing.JTextField jTextFieldHoTen;
    // End of variables declaration//GEN-END:variables
}
