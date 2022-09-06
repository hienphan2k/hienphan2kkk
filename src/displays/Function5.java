/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays;

import controllers.TaskController;
import java.util.ArrayList;
import java.util.List;
import controllers.Task;

/**
 *
 * @author Hien Phan
 */
public class Function5 extends javax.swing.JPanel {

    /**
     * Creates new form Task5
     */
    public Function5() {
        initComponents();
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("QuanLyQuy", jpnQuanLyQuy));
        tasks.add(new Task("QuanLyQua", jpnQuanLyQua));
        tasks.add(new Task("TangQua", jpnLapDanhSach));
        
        TaskController controller = new TaskController(jpnWorkplace5, tasks);
        controller.setDisplay("QuanLyQuy", jpnQuanLyQuy);
        controller.setEvent();
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
        jpnQuanLyQuy = new javax.swing.JPanel();
        jlbQuanLyQuy = new javax.swing.JLabel();
        jpnQuanLyQua = new javax.swing.JPanel();
        jlbQuanLyQua = new javax.swing.JLabel();
        jpnLapDanhSach = new javax.swing.JPanel();
        jlbTangQua = new javax.swing.JLabel();
        jpnWorkplace5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jpnQuanLyQuy.setBackground(new java.awt.Color(236, 236, 236));

        jlbQuanLyQuy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbQuanLyQuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQuanLyQuy.setText("Quản lý quỹ");

        javax.swing.GroupLayout jpnQuanLyQuyLayout = new javax.swing.GroupLayout(jpnQuanLyQuy);
        jpnQuanLyQuy.setLayout(jpnQuanLyQuyLayout);
        jpnQuanLyQuyLayout.setHorizontalGroup(
            jpnQuanLyQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLyQuy, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
        jpnQuanLyQuyLayout.setVerticalGroup(
            jpnQuanLyQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLyQuy, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnQuanLyQua.setBackground(new java.awt.Color(236, 236, 236));

        jlbQuanLyQua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbQuanLyQua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQuanLyQua.setText("Quản lý loại quà");

        javax.swing.GroupLayout jpnQuanLyQuaLayout = new javax.swing.GroupLayout(jpnQuanLyQua);
        jpnQuanLyQua.setLayout(jpnQuanLyQuaLayout);
        jpnQuanLyQuaLayout.setHorizontalGroup(
            jpnQuanLyQuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLyQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnQuanLyQuaLayout.setVerticalGroup(
            jpnQuanLyQuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLyQua, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnLapDanhSach.setBackground(new java.awt.Color(236, 236, 236));

        jlbTangQua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbTangQua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTangQua.setText("Trao quà");

        javax.swing.GroupLayout jpnLapDanhSachLayout = new javax.swing.GroupLayout(jpnLapDanhSach);
        jpnLapDanhSach.setLayout(jpnLapDanhSachLayout);
        jpnLapDanhSachLayout.setHorizontalGroup(
            jpnLapDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTangQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnLapDanhSachLayout.setVerticalGroup(
            jpnLapDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTangQua, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnQuanLyQuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQuanLyQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnLapDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnQuanLyQuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQuanLyQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnLapDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnWorkplace5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnWorkplace5Layout = new javax.swing.GroupLayout(jpnWorkplace5);
        jpnWorkplace5.setLayout(jpnWorkplace5Layout);
        jpnWorkplace5Layout.setHorizontalGroup(
            jpnWorkplace5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        jpnWorkplace5Layout.setVerticalGroup(
            jpnWorkplace5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnWorkplace5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnWorkplace5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbQuanLyQua;
    private javax.swing.JLabel jlbQuanLyQuy;
    private javax.swing.JLabel jlbTangQua;
    private javax.swing.JPanel jpnLapDanhSach;
    private javax.swing.JPanel jpnQuanLyQua;
    private javax.swing.JPanel jpnQuanLyQuy;
    private javax.swing.JPanel jpnWorkplace5;
    // End of variables declaration//GEN-END:variables
}
