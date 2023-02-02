package lk.ijse.service.model;

import lk.ijse.service.to.User;
import lk.ijse.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {


    public static boolean add(User user) throws SQLException, ClassNotFoundException {
        String sql = "Insert into user values (?,?,?,?,?)";
        return CrudUtil.execute(sql, user.getUser_name(),user.getEmp_id(),user.getEmail(),user.getRole(),user.getPassword());
    }

    public static boolean delete(User user) throws SQLException, ClassNotFoundException {
        String sql = "delete from user where user_name = ?";
        return CrudUtil.execute(sql, user.getUser_name());
    }

    public static boolean update(User user) throws SQLException, ClassNotFoundException {
        String sql = "update user set emp_id=?, email=?, role=?, password=? where user_name=?";
        return CrudUtil.execute(sql, user.getEmp_id(),user.getEmail(),user.getRole(),user.getPassword(),user.getUser_name());
    }

    public static User search(String user_name) throws SQLException, ClassNotFoundException {
        String sql = "select * from user where user_name = ? ";
        ResultSet result = CrudUtil.execute(sql, user_name);

        if (result.next()){
            return new User(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
        }
        return null;
    }

    public static ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        String sql="select * from user";
        ResultSet resultSet =CrudUtil.execute(sql);
        return resultSet;
    }
}
