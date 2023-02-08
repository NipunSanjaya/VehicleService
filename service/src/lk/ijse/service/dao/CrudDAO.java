package lk.ijse.service.dao;

import lk.ijse.service.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T> extends SuperDAO {
     ResultSet getTableValues() throws SQLException, ClassNotFoundException;
     ArrayList<String> lordIds() throws SQLException, ClassNotFoundException;
     boolean update(T entity) throws SQLException, ClassNotFoundException;
     boolean delete(String id) throws SQLException, ClassNotFoundException;
     T search(String id) throws SQLException, ClassNotFoundException;
    boolean save(T entity) throws SQLException, ClassNotFoundException;
}
