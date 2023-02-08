package lk.ijse.service.bo.custom.impl;

import lk.ijse.service.bo.BOFactory;
import lk.ijse.service.bo.BOType;
import lk.ijse.service.bo.SuperBO;
import lk.ijse.service.bo.custom.VehicleBO;
import lk.ijse.service.dao.DAOFactory;
import lk.ijse.service.dao.DAOType;
import lk.ijse.service.dao.custom.VehicleDAO;
import lk.ijse.service.dto.VehicleDTO;
import lk.ijse.service.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {

    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDAOFactory().getDAO(DAOType.VEHICLE);
    @Override
    public  boolean save(VehicleDTO dto) throws SQLException, ClassNotFoundException {
        return vehicleDAO.save(new Vehicle(dto.getVeh_id(), dto.getCus_id(), dto.getType(), dto.getVeh_name()));
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return vehicleDAO.delete(id);
    }
    @Override
    public  boolean update(VehicleDTO dto) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(new Vehicle(dto.getVeh_id(), dto.getCus_id() , dto.getVeh_name(), dto.getType()));
    }
    @Override
    public  Vehicle search(String id) throws SQLException, ClassNotFoundException {
        return vehicleDAO.search(id);
    }
    @Override
    public  ArrayList<String> lordCusIds(String cus_id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
