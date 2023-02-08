package lk.ijse.service.bo.custom;

import lk.ijse.service.bo.SuperBO;
import lk.ijse.service.dto.EmployeeDTO;
import lk.ijse.service.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {


    boolean add(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    EmployeeDTO search(String id) throws SQLException, ClassNotFoundException;

    ResultSet getTableValues() throws SQLException, ClassNotFoundException;

    ArrayList<String> lordIds() throws SQLException, ClassNotFoundException;
}
