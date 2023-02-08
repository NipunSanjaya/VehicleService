package lk.ijse.service.dao.custom.impl;
import lk.ijse.service.dao.CrudUtil;
import lk.ijse.service.dao.custom.CustomerDAO;
import lk.ijse.service.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public  boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        String sql = "Insert into customer values (?,?,?,?,?) ";
        return CrudUtil.execute(sql, entity.getCus_id(), entity.getName(), entity.getAddress(), entity.getContact(), entity.getEmail());
    }

    public  Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from customer where cus_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()){
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
        }
        return null;
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql ="delete from customer where cus_id = ?";
        return CrudUtil.execute(sql, id);
    }

    public  boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        String sql = "update customer set name=?, address=?, contact=?, email=? where cus_id=?";
        return CrudUtil.execute(sql, entity.getName(),entity.getAddress(),entity.getContact(),entity.getEmail(),entity.getCus_id());
    }

    public  ArrayList<String> lordIds() throws SQLException, ClassNotFoundException {
        String sql = "select cus_id from customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> ids = new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }


    public  ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        String sql="select * from customer";
        ResultSet resultSet =CrudUtil.execute(sql);
        return resultSet;
    }
}
