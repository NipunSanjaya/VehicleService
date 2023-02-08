package lk.ijse.service.dao.custom;

import lk.ijse.service.dao.CrudDAO;
import lk.ijse.service.entity.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiceDAO extends CrudDAO<Services> {
    ArrayList<String> VehicleIds(String vehicleType) throws SQLException, ClassNotFoundException;

    ResultSet serviceDetails(String ser_id) throws SQLException, ClassNotFoundException;
}
