package lk.ijse.service.bo.custom;

import lk.ijse.service.bo.SuperBO;
import lk.ijse.service.dto.SuppliersDTO;
import lk.ijse.service.entity.Suppliers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SuppliersBO extends SuperBO {
    boolean save(SuppliersDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean update(SuppliersDTO dto) throws SQLException, ClassNotFoundException;

    Suppliers search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> supId() throws SQLException, ClassNotFoundException;

    String supName(String sup_id) throws SQLException, ClassNotFoundException;

    ResultSet getTableValues() throws SQLException, ClassNotFoundException;
}
