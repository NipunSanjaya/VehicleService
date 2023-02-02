package lk.ijse.service.model;

import lk.ijse.service.to.User;
import lk.ijse.service.to.Vehicle;
import lk.ijse.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleModel {
    public static boolean add(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        String sql = "Insert into vehicle values (?,?,?,?)";
        return CrudUtil.execute(sql, vehicle.getVeh_id(),vehicle.getCus_id(),vehicle.getType(),vehicle.getVeh_name());
    }

    public static boolean delete(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        String sql = "delete from vehicle where veh_id = ?";
        return CrudUtil.execute(sql, vehicle.getVeh_id());
    }

    public static boolean update(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        String sql = "update vehicle set cus_id=?, type=?, veh_name=? where veh_id=?";
        return CrudUtil.execute(sql, vehicle.getCus_id(),vehicle.getType(),vehicle.getVeh_name(),vehicle.getVeh_id());
    }

    public static Vehicle search(String veh_id) throws SQLException, ClassNotFoundException {
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

    public static ArrayList<String> lordVehNum(String cus_id) throws SQLException, ClassNotFoundException {
        String sql = "select veh_id from vehicle where cus_id = ?";
        ResultSet result = CrudUtil.execute(sql, cus_id);

        ArrayList<String> vehNum = new ArrayList<>();
        while (result.next()){
            vehNum.add(result.getString(1));
        }
        return vehNum;
    }
}
