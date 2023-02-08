package lk.ijse.service.dao.custom.impl;

import lk.ijse.service.dao.custom.VehicleDAO;
import lk.ijse.service.entity.Vehicle;
import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    public  boolean save(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        String sql = "Insert into vehicle values (?,?,?,?)";
        return CrudUtil.execute(sql, vehicle.getVeh_id(),vehicle.getCus_id(),vehicle.getType(),vehicle.getVeh_name());
    }

    public  boolean delete(String  id) throws SQLException, ClassNotFoundException {
        String sql = "delete from vehicle where veh_id = ?";
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

    public  boolean update(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        String sql = "update vehicle set cus_id=?, type=?, veh_name=? where veh_id=?";
        return CrudUtil.execute(sql, vehicle.getCus_id(),vehicle.getType(),vehicle.getVeh_name(),vehicle.getVeh_id());
    }

    public  Vehicle search(String veh_id) throws SQLException, ClassNotFoundException {
        String sql = "select * from vehicle where veh_id = ? ";
        ResultSet result = CrudUtil.execute(sql, veh_id);

        if (result.next()){
            return new Vehicle(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }

    public  ArrayList<String> lordVehNum(String cus_id) throws SQLException, ClassNotFoundException {
        String sql = "select veh_id from vehicle where cus_id = ?";
        ResultSet result = CrudUtil.execute(sql, cus_id);

        ArrayList<String> vehNum = new ArrayList<>();
        while (result.next()){
            vehNum.add(result.getString(1));
        }
        return vehNum;
    }
}
