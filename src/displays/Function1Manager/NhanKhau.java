/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays.Function1Manager;

import controllers.Function1.NhanKhauController;
import displays.MainFrame;

/**
 *
 * @author Hien Phan
 */
public class NhanKhau extends javax.swing.JPanel {

    /**
     * Creates new form NhanKhau
     */
    public NhanKhau() {

        initComponents();
        NhanKhauController controller = new NhanKhauController(jTable, txtSearch);
        txtTong.setText("" + jTable.getRowCount());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnTamTru = new javax.swing.JButton();
        btnTamVang = new javax.swing.JButton();
        btnQuayVe = new javax.swing.JButton();
        btnChuyenDi = new javax.swing.JButton();
        btnKhaiTu = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hộ khẩu", "Số CMT/CCCD", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(22);
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(35);
            jTable.getColumnModel().getColumn(1).setMinWidth(70);
            jTable.getColumnModel().getColumn(1).setMaxWidth(70);
            jTable.getColumnModel().getColumn(2).setMinWidth(100);
            jTable.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable.getColumnModel().getColumn(3).setMinWidth(120);
            jTable.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable.getColumnModel().getColumn(4).setMinWidth(100);
            jTable.getColumnModel().getColumn(4).setMaxWidth(100);
            jTable.getColumnModel().getColumn(5).setMinWidth(60);
            jTable.getColumnModel().getColumn(5).setMaxWidth(60);
            jTable.getColumnModel().getColumn(7).setMinWidth(80);
            jTable.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnTamTru.setBackground(new java.awt.Color(236, 236, 236));
        btnTamTru.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTamTru.setText("ĐK tạm trú");
        btnTamTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamTruActionPerformed(evt);
            }
        });

        btnTamVang.setBackground(new java.awt.Color(236, 236, 236));
        btnTamVang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTamVang.setText("ĐK tạm vắng");
        btnTamVang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamVangActionPerformed(evt);
            }
        });

        btnQuayVe.setBackground(new java.awt.Color(236, 236, 236));
        btnQuayVe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuayVe.setText("Quay về");
        btnQuayVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayVeActionPerformed(evt);
            }
        });

        btnChuyenDi.setBackground(new java.awt.Color(236, 236, 236));
        btnChuyenDi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChuyenDi.setText("Chuyển đi");
        btnChuyenDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDiActionPerformed(evt);
            }
        });

        btnKhaiTu.setBackground(new java.awt.Color(236, 236, 236));
        btnKhaiTu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKhaiTu.setText("Khai tử");
        btnKhaiTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhaiTuActionPerformed(evt);
            }
        });

        btnThemMoi.setBackground(new java.awt.Color(236, 236, 236));
        btnThemMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tổng nhân khẩu:");

        txtTong.setEditable(false);
        txtTong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nhập mã HK/Số CMT/CCCD/Họ tên:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnTamTru, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTamVang, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQuayVe, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChuyenDi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKhaiTu, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuayVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTamVang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnTamTru, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(btnThemMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                            .addComponent(btnChuyenDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKhaiTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTamTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTamTruActionPerformed
        NhanKhau_TamTru tamTru = new NhanKhau_TamTru();
        MainFrame.it.setEnabled(false);
        tamTru.setLocationRelativeTo(null);
        tamTru.setVisible(true);
    }//GEN-LAST:event_btnTamTruActionPerformed

    private void btnTamVangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTamVangActionPerformed
        NhanKhau_TamVang tamVang = new NhanKhau_TamVang();
        MainFrame.it.setEnabled(false);
        tamVang.setLocationRelativeTo(null);
        tamVang.setVisible(true);
    }//GEN-LAST:event_btnTamVangActionPerformed

    private void btnQuayVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayVeActionPerformed
        NhanKhau_QuayVe quayVe = new NhanKhau_QuayVe();
        MainFrame.it.setEnabled(false);
        quayVe.setLocationRelativeTo(null);
        quayVe.setVisible(true);
    }//GEN-LAST:event_btnQuayVeActionPerformed

    private void btnChuyenDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDiActionPerformed
        NhanKhau_ChuyenDi chuyenDi = new NhanKhau_ChuyenDi();
        MainFrame.it.setEnabled(false);
        chuyenDi.setLocationRelativeTo(null);
        chuyenDi.setVisible(true);
    }//GEN-LAST:event_btnChuyenDiActionPerformed

    private void btnKhaiTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhaiTuActionPerformed
        NhanKhau_KhaiTu khaiTu = new NhanKhau_KhaiTu();
        MainFrame.it.setEnabled(false);
        khaiTu.setLocationRelativeTo(null);
        khaiTu.setVisible(true);
    }//GEN-LAST:event_btnKhaiTuActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        NhanKhau_ThemMoi themMoi = new NhanKhau_ThemMoi();
        MainFrame.it.setEnabled(false);
        themMoi.setLocationRelativeTo(null);
        themMoi.setVisible(true);    
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void txtTongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDi;
    private javax.swing.JButton btnKhaiTu;
    private javax.swing.JButton btnQuayVe;
    private javax.swing.JButton btnTamTru;
    private javax.swing.JButton btnTamVang;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
