/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hien Phan
 */
public class MysqlConnection {
    
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_dan_cu", "root", "");
        return connection;
    }
}
