package lk.ijse.service.bo.custom.impl;

import lk.ijse.service.bo.custom.ServiceBO;
import lk.ijse.service.dao.CrudUtil;
import lk.ijse.service.dao.DAOFactory;
import lk.ijse.service.dao.DAOType;
import lk.ijse.service.dao.custom.ServiceDAO;
import lk.ijse.service.dto.ServicesDTO;
import lk.ijse.service.entity.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceBOImpl implements ServiceBO {

    ServiceDAO serviceDAO = (ServiceDAO) DAOFactory.getDAOFactory().getDAO(DAOType.SERVICES);
    @Override
    public  boolean save(ServicesDTO dto) throws SQLException, ClassNotFoundException {
        return serviceDAO.save(new Services(dto.getSer_id(), dto.getSer_name(), dto.getSer_type(), dto.getPrice()));
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return serviceDAO.delete(id);
    }
    @Override
    public  boolean update(ServicesDTO dto) throws SQLException, ClassNotFoundException {
        return serviceDAO.update(new Services(dto.getSer_id(), dto.getSer_name(), dto.getSer_type(), dto.getPrice()));
    }
    @Override
    public  Services search(String ser_id) throws SQLException, ClassNotFoundException {
        return serviceDAO.search(ser_id);
    }
    @Override
    public  ArrayList<String> lordIds(String vehicleType) throws SQLException, ClassNotFoundException {
        return serviceDAO.VehicleIds(vehicleType);
    }
    @Override
    public  ResultSet serviceDetails(String ser_id) throws SQLException, ClassNotFoundException {
        return serviceDAO.serviceDetails(ser_id);
    }
}
