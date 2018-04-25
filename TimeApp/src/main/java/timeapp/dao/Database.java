/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeapp.dao;

import java.sql.*;
/**
 *
 * @author oleg
 */
public class Database {
    
    private String databaseAddress;
    
    public Database(String dtb) throws ClassNotFoundException {
        this.databaseAddress = dtb;
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
}
