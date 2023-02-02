package lk.ijse.service.model;
import lk.ijse.service.to.Customer;
import lk.ijse.service.util.CrudUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {

    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "Insert into customer values (?,?,?,?,?) ";
        return CrudUtil.execute(sql, customer.getCus_id(), customer.getName(), customer.getAddress(), customer.getContact(), customer.getEmail());
    }

    public static Customer search(String cus_id) throws SQLException, ClassNotFoundException {
        String sql = "select * from customer where cus_id = ?";
        ResultSet result = CrudUtil.execute(sql, cus_id);

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


    public static boolean delete(Customer customer) throws SQLException, ClassNotFoundException {
        String sql ="delete from customer where cus_id = ?";
        return CrudUtil.execute(sql, customer.getCus_id());
    }

    public static boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "update customer set name=?, address=?, contact=?, email=? where cus_id=?";
        return CrudUtil.execute(sql, customer.getName(),customer.getAddress(),customer.getContact(),customer.getEmail(),customer.getCus_id());
    }

    public static ArrayList<String> lordIds() throws SQLException, ClassNotFoundException {
        String sql = "select cus_id from customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> ids = new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }


    public static ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        String sql="select * from customer";
        ResultSet resultSet =CrudUtil.execute(sql);
        return resultSet;
    }
}
