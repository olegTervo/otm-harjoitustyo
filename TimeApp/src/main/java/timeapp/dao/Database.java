package timeapp.dao;

import java.sql.*;
/**
 *
 * @author oleg
 * luokka luo tietokantaolio
 * 
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
