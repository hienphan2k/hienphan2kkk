/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Function1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.ThayDoiHKModel;
import utilities.ConnectDB;
import utilities.MysqlConnection;

/**
 *
 * @author Hien Phan
 */
public class HoKhau_InfoController {

    public void themThayDoiHK(ThayDoiHKModel model) {
        try {
            ConnectDB.getInstance();
            try ( Connection connection = ConnectDB.getConnection()) {
                String query = "INSERT INTO thaydoihokhau(mahokhau, ttintdoi, ndtdoi, ghichu) "
                        + "VALUES (?,?,?,?)";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    st.setString(1, model.getMaHoKhau());
                    st.setString(2, model.getThongTinThayDoi());
                    st.setString(3, model.getNoiDungThayDoi());
                    st.setString(4, model.getGhiChu());

                    st.execute();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
}
