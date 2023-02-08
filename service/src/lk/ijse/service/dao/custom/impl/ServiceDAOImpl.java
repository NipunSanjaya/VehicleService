package lk.ijse.service.dao.custom.impl;

import lk.ijse.service.dao.custom.ServiceDAO;
import lk.ijse.service.dto.ServicesDTO;
import lk.ijse.service.entity.Services;
import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDAOImpl implements ServiceDAO {
    public  boolean save(Services entity) throws SQLException, ClassNotFoundException {
        String sql = "Insert into services values (?,?,?,?)";
        return CrudUtil.execute(sql, entity.getSer_id(), entity.getSer_name(), entity.getSer_type(), entity.getPrice());
    }

    public  boolean delete(String  id) throws SQLException, ClassNotFoundException {
        String sql = "delete from services where ser_id = ?";
        return CrudUtil.execute(sql, id);
    }

    @Override
    public ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> lordIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean update(Services dto) throws SQLException, ClassNotFoundException {
        String sql = "update services set ser_name=?, ser_type=?, price=? where ser_id=?";
        return CrudUtil.execute(sql, dto.getSer_name(), dto.getSer_type(), dto.getPrice(), dto.getSer_id());
    }

    public  Services search(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from services where ser_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()){
            return new Services(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4)

            );
        }
        return null;
    }
    @Override
    public  ArrayList<String> VehicleIds(String vehicleType) throws SQLException, ClassNotFoundException {
        String sql = "select ser_id from services where ser_type=?";
        ResultSet result = CrudUtil.execute(sql, vehicleType);

        ArrayList<String> ids = new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }
    @Override
    public  ResultSet serviceDetails(String ser_id) throws SQLException, ClassNotFoundException {
        String sql = "select * from services where ser_id = ?";
        ResultSet result = CrudUtil.execute(sql, ser_id);
        return result;
    }
}
