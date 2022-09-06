/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Function1;

import displays.Function1Manager.NhanKhau_Info;
import displays.MainFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import utilities.ConnectDB;
import utilities.MysqlConnection;

/**
 *
 * @author Hien Phan
 */
public class NhanKhauController {

    private List<NhanKhauModel> listNK = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTextField txtSearch;

    public NhanKhauController() {
    }

    public NhanKhauController(JTable table, JTextField txtSearch) {
        this.tableModel = (DefaultTableModel) table.getModel();
        this.txtSearch = txtSearch;
        listNK = findAll();
        showNhanKhau();
        initAction();

        //xu ly su kien khi nhay dup vao 1 hang trong bang
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    NhanKhauModel temp = listNK.get(table.getSelectedRow());
                    NhanKhau_Info info = new NhanKhau_Info(temp);
                    info.txt1.setVisible(false);
                    info.txt2.setVisible(false);
                    info.lb1.setVisible(false);
                    info.lb2.setVisible(false);
                    MainFrame.it.setEnabled(false);
                    info.setLocationRelativeTo(null);
                    info.setVisible(true);
                }
            }

        });
    }

    private void showNhanKhau() {
        tableModel.setRowCount(0);

        listNK.forEach(item -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.getMaHoKhau(), item.getCmnd(),
                item.getHoTen(), item.getNgaySinh(), item.getGioiTinh(), item.getDcHienNay(),
                (("cập nhật".equals(item.getTinhTrang().trim())) || ("chuyển đi".equals(item.getTinhTrang().trim())))
                ? "sinh sống" : item.getTinhTrang()});
        });
    }

    private List<NhanKhauModel> findAll() {
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT *  FROM nhankhau LEFT JOIN "
                        + "(SELECT idnhankhau, mahokhau FROM giadinh INNER JOIN hokhau ON hokhau.id = giadinh.idhokhau) AS A "
                        + "ON nhankhau.id = A.idnhankhau "
                        + "WHERE tinhtrang LIKE 'sinh sống' "
                        + "OR (tinhtrang LIKE 'tạm trú' AND tungay <= curdate() AND denngay >= curdate()) "
                        + "OR (tinhtrang LIKE 'tạm vắng' AND tungay <= curdate() AND denngay >= curdate()) "
                        + "OR (tinhtrang LIKE 'chuyển đi' AND ngaychuyendi > curdate()) "
                        + "OR (tinhtrang LIKE 'cập nhật' AND tungay > curdate()) "
                        + "ORDER BY mahokhau, ngaysinh";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        NhanKhauModel nhanKhau = new NhanKhauModel();

                        nhanKhau.setId(rs.getInt("id"));
                        nhanKhau.setMaHoKhau(rs.getString("mahokhau"));
                        nhanKhau.setHoTen(rs.getString("hoten"));
                        nhanKhau.setBiDanh(rs.getString("bidanh"));
                        nhanKhau.setNgaySinh(rs.getDate("ngaysinh"));
                        nhanKhau.setGioiTinh(rs.getString("gioitinh"));
                        nhanKhau.setNoiSinh(rs.getString("noisinh"));
                        nhanKhau.setNguyenQuan(rs.getString("nguyenquan"));
                        nhanKhau.setDcHienNay(rs.getString("dchiennay"));
                        nhanKhau.setDanToc(rs.getString("dantoc"));
                        nhanKhau.setTonGiao(rs.getString("tongiao"));
                        nhanKhau.setQuocTich(rs.getString("quoctich"));
                        nhanKhau.setNgheNghiep(rs.getString("nghenghiep"));
                        nhanKhau.setNoiLamViec(rs.getString("noilamviec"));
                        nhanKhau.setCmnd(rs.getString("cmnd"));
                        nhanKhau.setNgayCap(rs.getDate("ngaycap"));
                        nhanKhau.setNoiCap(rs.getString("noicap"));
                        nhanKhau.setNgayChuyenDen(rs.getDate("ngaychuyenden"));
                        nhanKhau.setNoiTruocChuyenDen(rs.getString("noitruocchuyenden"));
                        nhanKhau.setNgayChuyenDi(rs.getDate("ngaychuyendi"));
                        nhanKhau.setNoiDen(rs.getString("noiden"));
                        nhanKhau.setTinhTrang(rs.getString("tinhtrang"));
                        nhanKhau.setTuNgay(rs.getDate("tungay"));
                        nhanKhau.setDenNgay(rs.getDate("denngay"));
                        nhanKhau.setNgayLap(rs.getDate("ngaylap"));

                        list.add(nhanKhau);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    private void initAction() {
        this.txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listNK = findByCondition(key.trim());
                showNhanKhau();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listNK = findByCondition(key.trim());
                showNhanKhau();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listNK = findByCondition(key.trim());
                showNhanKhau();
            }
        });
    }

    public List<NhanKhauModel> findByCondition(String key) {
        if (key.isEmpty()) {
            return this.findAll();
        }
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT *  FROM nhankhau "
                        + "LEFT JOIN (SELECT idnhankhau, mahokhau FROM giadinh INNER JOIN hokhau ON hokhau.id = giadinh.idhokhau) AS A "
                        + "ON nhankhau.id = A.idnhankhau "
                        + "WHERE (cmnd LIKE '%" + key + "%' OR hoten LIKE '%" + key + "%') "
                        + "AND (tinhtrang LIKE 'sinh sống' "
                        + "OR (tinhtrang LIKE 'tạm trú' AND tungay <= curdate() AND denngay >= curdate()) "
                        + "OR (tinhtrang LIKE 'tạm vắng' AND tungay <= curdate() AND denngay >= curdate()) "
                        + "OR (tinhtrang LIKE 'chuyển đi' AND ngaychuyendi > curdate()) "
                        + "OR (tinhtrang LIKE 'cập nhật' AND tungay > curdate())) "
                        + "ORDER BY mahokhau, ngaysinh";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        NhanKhauModel nhanKhau = new NhanKhauModel();
                        
                        nhanKhau.setId(rs.getInt("id"));
                        nhanKhau.setMaHoKhau(rs.getString("mahokhau"));
                        nhanKhau.setHoTen(rs.getString("hoten"));
                        nhanKhau.setBiDanh(rs.getString("bidanh"));
                        nhanKhau.setNgaySinh(rs.getDate("ngaysinh"));
                        nhanKhau.setGioiTinh(rs.getString("gioitinh"));
                        nhanKhau.setNoiSinh(rs.getString("noisinh"));
                        nhanKhau.setNguyenQuan(rs.getString("nguyenquan"));
                        nhanKhau.setDcHienNay(rs.getString("dchiennay"));
                        nhanKhau.setDanToc(rs.getString("dantoc"));
                        nhanKhau.setTonGiao(rs.getString("tongiao"));
                        nhanKhau.setQuocTich(rs.getString("quoctich"));
                        nhanKhau.setNgheNghiep(rs.getString("nghenghiep"));
                        nhanKhau.setNoiLamViec(rs.getString("noilamviec"));
                        nhanKhau.setCmnd(rs.getString("cmnd"));
                        nhanKhau.setNgayCap(rs.getDate("ngaycap"));
                        nhanKhau.setNoiCap(rs.getString("noicap"));
                        nhanKhau.setNgayChuyenDen(rs.getDate("ngaychuyenden"));
                        nhanKhau.setNoiTruocChuyenDen(rs.getString("noitruocchuyenden"));
                        nhanKhau.setNgayChuyenDi(rs.getDate("ngaychuyendi"));
                        nhanKhau.setNoiDen(rs.getString("noiden"));
                        nhanKhau.setTinhTrang(rs.getString("tinhtrang"));
                        nhanKhau.setTuNgay(rs.getDate("tungay"));
                        nhanKhau.setDenNgay(rs.getDate("denngay"));
                        nhanKhau.setNgayLap(rs.getDate("ngaylap"));

                        list.add(nhanKhau);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
}
