package lk.ijse.service.dao.custom.impl;

import lk.ijse.service.dao.SuperDAO;
import lk.ijse.service.dao.custom.SuppliersDAO;
import lk.ijse.service.entity.Suppliers;
import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersDAOImpl implements SuppliersDAO {

    public  boolean save(Suppliers entity) throws SQLException, ClassNotFoundException {
        String sql = "Insert into suppliers values (?,?,?,?,?)";
        return CrudUtil.execute(sql, entity.getSup_id(),entity.getName(), entity.getAddress(), entity.getContact(), entity.getEmail());
    }

    public  boolean delete(String  id) throws SQLException, ClassNotFoundException {
        String sql = "delete from suppliers where sup_id = ?";
        return CrudUtil.execute(sql, id);
    }

    public  boolean update(Suppliers entity) throws SQLException, ClassNotFoundException {
        String sql = "update suppliers set name=?, address=?, contact=?, email=? where sup_id=?";
        return CrudUtil.execute(sql, entity.getName(), entity.getAddress(),entity.getContact(),
                entity.getEmail(), entity.getSup_id());
    }

    public  Suppliers search(String sup_id) throws SQLException, ClassNotFoundException {
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

    public  ArrayList<String> supId() throws SQLException, ClassNotFoundException {
        /*String sql = "select sup_id from suppliers";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> ids = new ArrayList<>();

        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;*/
        return null;
    }

    public  String supName(String sup_id) throws SQLException, ClassNotFoundException {
        /*String sql = "select name from suppliers where sup_id =?";
        ResultSet result = CrudUtil.execute(sql, sup_id);

        if (result.next()) {
            return result.getString(1);
        }
        return "";*/
        return null;
    }

    public  ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        String sql="select * from suppliers";
        ResultSet resultSet =CrudUtil.execute(sql);
        return resultSet;
    }

    @Override
    public ArrayList<String> lordIds() throws SQLException, ClassNotFoundException {
        return null;
    }
}
