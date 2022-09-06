/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays.Function1Manager;

import controllers.Function1.CapNhatController;
import controllers.Function1.HoKhau_InfoController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.HoKhauModel;
import models.ThanhVienModel;
import models.ThayDoiHKModel;

/**
 *
 * @author Hien Phan
 */
public class HoKhau_DoiChuHo extends javax.swing.JFrame {

    /**
     * Creates new form HoKhau_DoiChuHo
     */
    HoKhauModel hoKhau;
    private List<ThanhVienModel> listOld = new ArrayList<>();
    private DefaultTableModel tableModelOld;
    private List<ThanhVienModel> listNew = new ArrayList<>();
    private DefaultTableModel tableModelNew;
    private CapNhatController cnController;
    private HoKhau_InfoController hkInfoController;
    private String ttinChuHoCu;
    boolean checkChuHo = false; //check hộ mới có chủ hộ chưa

    public HoKhau_DoiChuHo(HoKhauModel hoKhau, List<ThanhVienModel> list) {
        initComponents();
        cnController = new CapNhatController();
        this.hkInfoController = new HoKhau_InfoController();
        
        this.ttinChuHoCu = hoKhau.getHoTenChuHo() + " - " + hoKhau.getCmndChuHo();
        this.listOld = list;
        this.hoKhau = hoKhau;
        this.tableModelOld = (DefaultTableModel) table1.getModel();
        this.tableModelNew = (DefaultTableModel) table2.getModel();
        showOld();

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    ThanhVienModel temp = listOld.get(table1.getSelectedRow());
                    if (listNew.contains(temp)) {
                        JOptionPane.showMessageDialog(rootPane, "Đã chỉnh sửa thành viên này!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            temp.giaDinh.setQhChuHo("." + JOptionPane.showInputDialog("Điền quan hệ với chủ hộ mới:").trim());
                            if (temp.giaDinh.getQhChuHo().equalsIgnoreCase(".chủ hộ")) {
                                if (checkChuHo) {
                                    JOptionPane.showMessageDialog(rootPane, "Đã có chủ hộ!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    hoKhau.setCmndChuHo(temp.nhanKhau.getCmnd());
                                    hoKhau.setHoTenChuHo(temp.nhanKhau.getHoTen());
                                    checkChuHo = true;
                                    listNew.add(temp);
                                    showNew();
                                }
                            } else {
                                listNew.add(temp);
                                showNew();
                            }
                        } catch (NullPointerException ee) {
                        }
                    }
                }
            }
        });
        
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    ThanhVienModel temp = listNew.get(table2.getSelectedRow());
                    if (JOptionPane.showConfirmDialog(null, "Xóa người này?", "Warning!", JOptionPane.YES_NO_OPTION) == 0) {
                        if (listNew.remove(temp)) {
                            showNew();
                        }
                        if (temp.giaDinh.getQhChuHo().equalsIgnoreCase(".chủ hộ")) {
                            checkChuHo = false;
                        }
                    }
                }
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng?", "Warning!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
        });
    }

    private void close() {
        HoKhau_Info.it.setEnabled(true);
        dispose();
    }

    private void showOld() {
        tableModelOld.setRowCount(0);

        listOld.forEach(item -> {
            tableModelOld.addRow(new Object[]{tableModelOld.getRowCount() + 1, item.nhanKhau.getCmnd(), item.nhanKhau.getHoTen(),
                item.nhanKhau.getNgaySinh(), item.nhanKhau.getGioiTinh(), item.giaDinh.getQhChuHo(),
                (("cập nhật".equals(item.nhanKhau.getTinhTrang().trim())) || ("chuyển đi".equals(item.nhanKhau.getTinhTrang().trim())))
                ? "sinh sống" : item.nhanKhau.getTinhTrang()});
        });
    }

    private void showNew() {
        tableModelNew.setRowCount(0);

        listNew.forEach(item -> {
            tableModelNew.addRow(new Object[]{tableModelNew.getRowCount() + 1, item.nhanKhau.getCmnd(), item.nhanKhau.getHoTen(),
                item.nhanKhau.getNgaySinh(), item.nhanKhau.getGioiTinh(), item.giaDinh.getQhChuHo().substring(1),
                (("cập nhật".equals(item.nhanKhau.getTinhTrang().trim())) || ("chuyển đi".equals(item.nhanKhau.getTinhTrang().trim())))
                ? "sinh sống" : item.nhanKhau.getTinhTrang()});
        });
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
        table2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDoiChuHo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đổi chủ hộ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        table2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số CMT/CCCD", "Họ tên", "Ngày sinh", "Giới tính", "QH với chủ hộ", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setRowHeight(22);
        jScrollPane1.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setMinWidth(30);
            table2.getColumnModel().getColumn(0).setMaxWidth(30);
            table2.getColumnModel().getColumn(1).setMinWidth(100);
            table2.getColumnModel().getColumn(1).setMaxWidth(100);
            table2.getColumnModel().getColumn(4).setMinWidth(90);
            table2.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        table1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số CMT/CCCD", "Họ tên", "Ngày sinh", "Giới tính", "QH với chủ hộ", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setRowHeight(22);
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMinWidth(30);
            table1.getColumnModel().getColumn(0).setMaxWidth(30);
            table1.getColumnModel().getColumn(1).setMinWidth(100);
            table1.getColumnModel().getColumn(1).setMaxWidth(100);
            table1.getColumnModel().getColumn(4).setMinWidth(90);
            table1.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Hộ khẩu trước khi đổi chủ hộ:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Hộ khẩu sau khi đổi chủ hộ:");

        btnDoiChuHo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDoiChuHo.setText("Đổi chủ hộ");
        btnDoiChuHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiChuHoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Nhấn đúp vào từng người để chỉnh sửa quan hệ với chủ hộ mới");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Nhấn đúp vào một người để xóa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDoiChuHo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnDoiChuHo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiChuHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiChuHoActionPerformed
        if (tableModelNew.getRowCount() != tableModelOld.getRowCount()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chỉnh sửa quan hệ với chủ hộ mới của tất cả thành viên!", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else if (checkChuHo == false) {
            JOptionPane.showMessageDialog(rootPane, "Hộ mới chưa có chủ hộ!", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else {
            ThayDoiHKModel model = new ThayDoiHKModel();
            model.setMaHoKhau(hoKhau.getMaHoKhau());
            model.setThongTinThayDoi("Đổi chủ hộ");
            model.setNoiDungThayDoi("Đổi từ: " + ttinChuHoCu);
            model.setGhiChu("Thành: " + hoKhau.getHoTenChuHo() + " - " + hoKhau.getCmndChuHo());
            hkInfoController.themThayDoiHK(model);
            cnController.capNhatHK(hoKhau.getId(), hoKhau);
            
            listNew.forEach(item -> {
                cnController.capNhatGD(item.giaDinh.getId(), item.giaDinh.getQhChuHo().substring(1));                
            });

            JOptionPane.showMessageDialog(rootPane, "Đổi chủ hộ thành công!");
            HoKhau_Info.it.setEnabled(true);
            dispose();
        }
    }//GEN-LAST:event_btnDoiChuHoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiChuHo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
