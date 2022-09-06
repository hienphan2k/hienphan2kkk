/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Function1;

import displays.Function1Manager.HoKhau_Info;
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
import models.HoKhauModel;
import utilities.ConnectDB;
import utilities.MysqlConnection;

/**
 *
 * @author Hien Phan
 */
public class HoKhauController {

    private List<HoKhauModel> listHK = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTextField txtSearch;

    public HoKhauController() {
    }

    public HoKhauController(JTable table, JTextField txtSearch) {
        this.tableModel = (DefaultTableModel) table.getModel();
        this.txtSearch = txtSearch;

        listHK = findAll();
        showHoKhau();
        initAction();

        //xu ly su kien khi nhay dup vao 1 hang trong bang
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    HoKhauModel temp = listHK.get(table.getSelectedRow());
                    HoKhau_Info info = new HoKhau_Info(temp);
                    MainFrame.it.setEnabled(false);
                    info.setLocationRelativeTo(null);
                    info.setVisible(true);
                }
            }
        });
    }

    private void showHoKhau() {
        tableModel.setRowCount(0);

        listHK.forEach(item -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.getMaHoKhau(),
                item.getHoTenChuHo(), item.getDiaChi()});
        });
    }

    public List<HoKhauModel> findAll() {
        List<HoKhauModel> list = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT *  FROM hokhau INNER JOIN "
                        + "(SELECT DISTINCT cmnd, hoten FROM nhankhau) AS A "
                        + "ON hokhau.cmndchuho = A.cmnd "
                        + "WHERE tinhtrang LIKE 'sinh sống' "
                        + "ORDER BY mahokhau";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        HoKhauModel hoKhau = new HoKhauModel();
                        
                        hoKhau.setId(rs.getInt("id"));
                        hoKhau.setMaHoKhau(rs.getString("mahokhau"));
                        hoKhau.setCmndChuHo(rs.getString("cmndchuho"));
                        hoKhau.setHoTenChuHo(rs.getString("hoten"));
                        hoKhau.setDiaChi(rs.getString("diachi"));
                        hoKhau.setNgayLap(rs.getDate("ngaylap"));
                        hoKhau.setTinhTrang(rs.getString("tinhtrang"));

                        list.add(hoKhau);
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
                listHK = findByCondition(key.trim());
                showHoKhau();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listHK = findByCondition(key.trim());
                showHoKhau();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listHK = findByCondition(key.trim());
                showHoKhau();
            }
        });
    }

    public List<HoKhauModel> findByCondition(String key) {
        if (key.isEmpty()) {
            return this.findAll();
        }
        List<HoKhauModel> list = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT *  FROM hokhau INNER JOIN "
                        + "(SELECT DISTINCT cmnd, hoten FROM nhankhau) AS A "
                        + "ON hokhau.cmndchuho = A.cmnd "
                        + "WHERE (mahokhau LIKE '%" + key + "%' OR hoten LIKE '%" + key + "%' OR cmndchuho LIKE '%" + key + "%') "
                        + "AND (tinhtrang LIKE 'sinh sống' "
                        + "OR (tinhtrang LIKE 'chuyển đi' AND ngaychuyendi > curdate())) "
                        + "ORDER BY mahokhau";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        HoKhauModel hoKhau = new HoKhauModel();
                        
                        hoKhau.setId(rs.getInt("id"));
                        hoKhau.setMaHoKhau(rs.getString("mahokhau"));
                        hoKhau.setCmndChuHo(rs.getString("cmndchuho"));
                        hoKhau.setHoTenChuHo(rs.getString("hoten"));
                        hoKhau.setDiaChi(rs.getString("diachi"));
                        hoKhau.setNgayLap(rs.getDate("ngaylap"));
                        hoKhau.setTinhTrang(rs.getString("tinhtrang"));

                        list.add(hoKhau);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
}
