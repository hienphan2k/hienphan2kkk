/*
 * xu ly dang nhap
 */
package controllers;

import java.sql.*;
import utilities.ConnectDB;
import utilities.MysqlConnection;

/**
 *
 * @author Hien Phan
 */
public class LoginController {

    public boolean login(String username, String pass) throws SQLException, ClassNotFoundException {
//        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection(); 
        System.out.println(connection);
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            st.setString(1, username);
            rs = st.executeQuery();
            if (rs == null) {
                return false;
            }
            while (rs.next()) {
                if (rs.getString("pass").equals(pass)) {
                    return true;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            close(st);
        }
        return false;
    }
    
    public void close(PreparedStatement stmt){
        if(stmt != null){
            try{
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
