package lk.ijse.service.model;

import lk.ijse.service.to.Item;
import lk.ijse.service.to.Services;
import lk.ijse.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceModel {
    public static boolean add(Services services) throws SQLException, ClassNotFoundException {
        String sql = "Insert into services values (?,?,?,?)";
        return CrudUtil.execute(sql, services.getSer_id(), services.getSer_name(), services.getSer_type(), services.getPrice());
    }

    public static boolean delete(Services services) throws SQLException, ClassNotFoundException {
        String sql = "delete from services where ser_id = ?";
        return CrudUtil.execute(sql, services.getSer_id());
    }

    public static boolean update(Services services) throws SQLException, ClassNotFoundException {
        String sql = "update services set ser_name=?, ser_type=?, price=? where ser_id=?";
        return CrudUtil.execute(sql, services.getSer_name(), services.getSer_type(), services.getPrice(), services.getSer_id());
    }

    public static Services search(String ser_id) throws SQLException, ClassNotFoundException {
        String sql = "select * from services where ser_id = ?";
        ResultSet result = CrudUtil.execute(sql, ser_id);

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

    public static ArrayList<String> lordIds(String vehicleType) throws SQLException, ClassNotFoundException {
        String sql = "select ser_id from services where ser_type=?";
        ResultSet result = CrudUtil.execute(sql, vehicleType);

        ArrayList<String> ids = new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }

    public static ResultSet serviceDetails(String ser_id) throws SQLException, ClassNotFoundException {
        String sql = "select * from services where ser_id = ?";
        ResultSet result = CrudUtil.execute(sql, ser_id);
        return result;
    }
}
