package lk.ijse.service.model;

import lk.ijse.service.to.Customer;
import lk.ijse.service.to.Employee;
import lk.ijse.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
    public static boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "Insert into employee values (?,?,?,?,?) ";
        return CrudUtil.execute(sql, employee.getEmp_id(), employee.getName(), employee.getAddress(), employee.getContact(), employee.getEmail());
    }

    public static boolean delete(Employee employee) throws SQLException, ClassNotFoundException {
        String sql ="delete from employee where emp_id = ?";
        return CrudUtil.execute(sql, employee.getEmp_id());
    }

    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "update employee set name=?, address=?, contact=?, email=? where emp_id=?";
        return CrudUtil.execute(sql, employee.getName(), employee.getAddress(), employee.getContact(), employee.getEmail(), employee.getEmp_id());
    }

    public static Employee search(String emp_id) throws SQLException, ClassNotFoundException {
        String sql = "select * from employee where emp_id = ?";

        ResultSet result = CrudUtil.execute(sql, emp_id);

        if (result.next()){
            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
        }
        return null;
    }

    public static ArrayList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        String sql = "select emp_id from employee";
        ResultSet employeeIds = CrudUtil.execute(sql);

        ArrayList<String > ids = new ArrayList<>();

        while (employeeIds.next()){
            ids.add(employeeIds.getString(1));
        }
        return ids;
    }

    public static ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        String sql="select * from employee";
        ResultSet resultSet =CrudUtil.execute(sql);
        return resultSet;
    }
}
