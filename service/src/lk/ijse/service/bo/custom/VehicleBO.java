package lk.ijse.service.bo.custom;

import lk.ijse.service.bo.SuperBO;
import lk.ijse.service.dto.VehicleDTO;
import lk.ijse.service.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO extends SuperBO {
    boolean save(VehicleDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean update(VehicleDTO dto) throws SQLException, ClassNotFoundException;

    Vehicle search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> lordCusIds(String cus_id) throws SQLException, ClassNotFoundException;
}
