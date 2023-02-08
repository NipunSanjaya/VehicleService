package lk.ijse.service.bo.custom;

import lk.ijse.service.bo.SuperBO;
import lk.ijse.service.dto.ServicesDTO;
import lk.ijse.service.entity.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiceBO extends SuperBO {
    boolean save(ServicesDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean update(ServicesDTO dto) throws SQLException, ClassNotFoundException;

    Services search(String ser_id) throws SQLException, ClassNotFoundException;

    ArrayList<String> lordIds(String vehicleType) throws SQLException, ClassNotFoundException;

    ResultSet serviceDetails(String ser_id) throws SQLException, ClassNotFoundException;
}
