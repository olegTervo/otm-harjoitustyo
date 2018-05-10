package timeapp.dao;

import java.sql.*;
import java.util.*;
/**
 *
 * @author oleg
 */
public interface Dao<T, K> {
    T findOne(K key) throws SQLException;
    List<T> findAll() throws SQLException;
    T saveOrUpdate(T object, K key) throws SQLException;
    void delete(K key) throws SQLException;
}
