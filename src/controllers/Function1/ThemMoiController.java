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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.GiaDinhModel;
import models.HoKhauModel;
import models.NhanKhauModel;
import utilities.ConnectDB;
import utilities.MysqlConnection;

/**
 *
 * @author Hien Phan
 */
public class ThemMoiController {

    private List<HoKhauModel> listHK = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTextField txtSearch;
    private HoKhauModel hoKhauSelected;

    public ThemMoiController() {
    }

    HoKhauController controller = new HoKhauController();

    public ThemMoiController(JTable table, JTextField txtSearch, JTextField txtMaHoKhau, JTextField txtTenChuHo) {

        this.tableModel = (DefaultTableModel) table.getModel();
        this.txtSearch = txtSearch;

        listHK = controller.findAll();
        showHoKhau();
        initAction();

        //xu ly su kien khi nhay chuot vao 1 hang trong bang
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HoKhauModel temp = listHK.get(table.getSelectedRow());
                if (e.getClickCount() == 1) {
                    hoKhauSelected = temp;
                    txtMaHoKhau.setText(hoKhauSelected.getMaHoKhau());
                    txtTenChuHo.setText(hoKhauSelected.getHoTenChuHo());
                } else {
                    HoKhau_Info info = new HoKhau_Info(temp);
                    info.btn1.setVisible(false);
                    info.btn2.setVisible(false);
                    MainFrame.it.setEnabled(false);
                    info.setLocationRelativeTo(null);
                    info.setVisible(true);
                }
            }

        });
    }

    //hiển thị các hộ khẩu đã có để chọn trong frame thêm mới
    private void showHoKhau() {
        tableModel.setRowCount(0);

        listHK.forEach(item -> {
            tableModel.addRow(new Object[]{item.getMaHoKhau(), item.getHoTenChuHo()});
        });
    }

    private void initAction() {
        this.txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listHK = controller.findByCondition(key.trim());
                showHoKhau();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listHK = controller.findByCondition(key.trim());
                showHoKhau();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listHK = controller.findByCondition(key.trim());
                showHoKhau();
            }
        });
    }

    //Kiem tra nhan khau da ton tai trong db voi tinh trang dang sinh song hoac tam tru chua
    public boolean checkCmndSs_Tt(String cmnd) {

        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT cmnd FROM nhankhau "
                        + "WHERE nhankhau.tinhtrang LIKE 'sinh sống' "
                        + "OR (tinhtrang LIKE 'tạm trú' AND denngay >= curdate()) ";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        if (cmnd.equals(rs.getString("cmnd"))) {
                            return false;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    //check cmnd xem da ton tai trong db voi tinh trang dang sinh song chua
    public boolean checkCmndSs(String cmnd) {

        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT cmnd FROM nhankhau "
                        + "WHERE nhankhau.tinhtrang LIKE 'sinh sống'";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        if (cmnd.equals(rs.getString("cmnd"))) {
                            return false;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    //sinh mã hộ khẩu mới tự động
    public String taoMaHK() {
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT MAX(id) AS id FROM hokhau";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        int id = rs.getInt("id") + 1;
                        return "HK" + id;
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return "HK1";
    }

    public void themNhanKhau(NhanKhauModel nhanKhau) {
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "INSERT INTO nhankhau(hoten, bidanh, ngaysinh, gioitinh, noisinh, nguyenquan, dchiennay, dantoc, tongiao, "
                        + "quoctich, nghenghiep, noilamviec, cmnd, ngaycap, noicap, ngaychuyenden, noitruocchuyenden, ngaychuyendi,"
                        + " tinhtrang, tungay, denngay, ngaylap) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    st.setString(1, nhanKhau.getHoTen());
                    st.setString(2, nhanKhau.getBiDanh());
                    Date ngaySinh = new Date(nhanKhau.getNgaySinh().getTime());
                    st.setDate(3, ngaySinh);
                    st.setString(4, nhanKhau.getGioiTinh());
                    st.setString(5, nhanKhau.getNoiSinh());
                    st.setString(6, nhanKhau.getNguyenQuan());
                    st.setString(7, nhanKhau.getDcHienNay());
                    st.setString(8, nhanKhau.getDanToc());
                    st.setString(9, nhanKhau.getTonGiao());
                    st.setString(10, nhanKhau.getQuocTich());
                    st.setString(11, nhanKhau.getNgheNghiep());
                    st.setString(12, nhanKhau.getNoiLamViec());
                    st.setString(13, nhanKhau.getCmnd());
                    if (nhanKhau.getNoiCap() == null || nhanKhau.getNoiCap().trim().isEmpty()) {
                        st.setDate(14, null);
                    } else if (nhanKhau.getNgayCap() != null) {
                        Date ngayCap = new Date(nhanKhau.getNgayCap().getTime());
                        st.setDate(14, ngayCap);
                    } else {
                        st.setDate(14, null);
                    }
                    st.setString(15, nhanKhau.getNoiCap());
                    if (nhanKhau.getNgayChuyenDen() != null) {
                        Date ngayChuyenDen = new Date(nhanKhau.getNgayChuyenDen().getTime());
                        st.setDate(16, ngayChuyenDen);
                    } else {
                        st.setDate(16, null);
                    }
                    st.setString(17, nhanKhau.getNoiTruocChuyenDen());
                    if (nhanKhau.getNgayChuyenDi() != null) {
                        Date ngayChuyenDi = new Date(nhanKhau.getNgayChuyenDi().getTime());
                        st.setDate(18, ngayChuyenDi);
                    } else {
                        st.setDate(18, null);
                    }
                    st.setString(19, nhanKhau.getTinhTrang());
                    if (nhanKhau.getTuNgay() != null) {
                        Date tuNgay = new Date(nhanKhau.getTuNgay().getTime());
                        st.setDate(20, tuNgay);
                    } else {
                        st.setDate(20, null);
                    }
                    if (nhanKhau.getDenNgay() != null) {
                        Date denNgay = new Date(nhanKhau.getDenNgay().getTime());
                        st.setDate(21, denNgay);
                    } else {
                        st.setDate(21, null);
                    }
                    Date ngayLap = new Date(nhanKhau.getNgayLap().getTime());
                    st.setDate(22, ngayLap);

                    st.execute();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void themHoKhau(HoKhauModel hoKhau) {
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "INSERT INTO hokhau(mahokhau, cmndchuho, diachi, ngaylap, tinhtrang) "
                        + "VALUES (?,?,?,?,?)";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    st.setString(1, hoKhau.getMaHoKhau());
                    st.setString(2, hoKhau.getCmndChuHo());
                    st.setString(3, hoKhau.getDiaChi());
                    Date ngayLap = new Date(hoKhau.getNgayLap().getTime());
                    st.setDate(4, ngayLap);
                    st.setString(5, hoKhau.getTinhTrang());

                    st.execute();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void themGiaDinh(String cmnd, String maHoKhau, String qhChuHo) {
        GiaDinhModel giaDinh = new GiaDinhModel();
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "SELECT id FROM nhankhau WHERE cmnd LIKE '" + cmnd + "' "
                        + "AND ( tinhtrang LIKE 'sinh sống' OR tinhtrang LIKE 'cập nhật')";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        giaDinh.setIdNhanKhau(rs.getInt("id"));
                    }
                }

                query = "SELECT id FROM hokhau WHERE mahokhau LIKE '" + maHoKhau + "'";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        giaDinh.setIdHoKhau(rs.getInt("id"));
                    }
                }

                query = "INSERT INTO giadinh(idhokhau, idnhankhau, quanhechuho) VALUES (?,?,?)";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    st.setInt(1, giaDinh.getIdHoKhau());
                    st.setInt(2, giaDinh.getIdNhanKhau());
                    st.setString(3, qhChuHo);

                    st.execute();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
}
