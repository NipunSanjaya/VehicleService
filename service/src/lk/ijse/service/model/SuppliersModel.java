package lk.ijse.service.model;

import lk.ijse.service.to.Employee;
import lk.ijse.service.to.Suppliers;
import lk.ijse.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersModel {
    public static boolean add(Suppliers suppliers) throws SQLException, ClassNotFoundException {
        String sql = "Insert into suppliers values (?,?,?,?,?)";
        return CrudUtil.execute(sql, suppliers.getSup_id(),suppliers.getName(), suppliers.getAddress(), suppliers.getContact(), suppliers.getEmail());
    }

    public static boolean delete(Suppliers suppliers) throws SQLException, ClassNotFoundException {
        String sql = "delete from suppliers where sup_id = ?";
        return CrudUtil.execute(sql, suppliers.getSup_id());
    }

    public static boolean update(Suppliers suppliers) throws SQLException, ClassNotFoundException {
        String sql = "update suppliers set name=?, address=?, contact=?, email=? where sup_id=?";
        return CrudUtil.execute(sql, suppliers.getName(), suppliers.getAddress(),suppliers.getContact(),
                suppliers.getEmail(), suppliers.getSup_id());
    }

    public static Suppliers search(String sup_id) throws SQLException, ClassNotFoundException {
        String sql = "select * from suppliers where sup_id =?";
        ResultSet result = CrudUtil.execute(sql, sup_id);

        if (result.next()){
            return new Suppliers(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
        }
        return null;
    }

    public static ArrayList<String> supId() throws SQLException, ClassNotFoundException {
        String sql = "select sup_id from suppliers";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> ids = new ArrayList<>();

        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }

    public static String supName(String sup_id) throws SQLException, ClassNotFoundException {
        String sql = "select name from suppliers where sup_id =?";
        ResultSet result = CrudUtil.execute(sql, sup_id);

        if (result.next()) {
            return result.getString(1);
        }
        return "";
    }

    public static ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        String sql="select * from suppliers";
        ResultSet resultSet =CrudUtil.execute(sql);
        return resultSet;
    }
}
