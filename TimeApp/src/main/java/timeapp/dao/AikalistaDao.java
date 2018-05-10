package timeapp.dao;

import java.sql.*;
import java.util.*;
import timeapp.domain.Kayttaja;

/**
 *
 * @author oleg
 * luokka hallinta tietokantaa
 */
public class AikalistaDao implements Dao<String, Integer> {
    
    private Database database;
    
    public AikalistaDao(Database database) {
        this.database = database;
    }

    @Override
    public String findOne(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Aikalista WHERE aika = ?");
        stmt.setInt(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        String a = rs.getString("Kayttaja");
        stmt.close();
        rs.close();
        conn.close();
        return a;
    }

    @Override
    public List<String> findAll() throws SQLException {
        List<String> users = new ArrayList();
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            users.add(rs.getString("nimi"));
        }
        return users;
    }

    @Override
    public String saveOrUpdate(String object, Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Aikalista (aika, kayttaja) VALUES (?, ?)");
        stmt.setInt(1, key);
        stmt.setString(2, object);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
        
        return object + " " + key;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Aikalista WHERE aika = ?");

        stmt.setInt(1, key);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
    
    public void souser(String s) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (nimi) VALUES (?)");
        
        stmt.setString(1, s);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
    
    public HashMap<Kayttaja, ArrayList<Integer>> varaukset() throws SQLException {
        HashMap<Kayttaja, ArrayList<Integer>> ans = new HashMap();
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from Aikalista");
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Kayttaja k = new Kayttaja(rs.getString("Kayttaja"));
            ans.putIfAbsent(k, new ArrayList());
            ans.get(k).add(rs.getInt("aika"));
        }
        return ans;
    }
    
}
