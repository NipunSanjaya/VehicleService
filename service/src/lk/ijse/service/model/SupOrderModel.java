package lk.ijse.service.model;

import lk.ijse.service.to.Sup_Order;
import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupOrderModel {

    public static boolean save(Sup_Order order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO sup_order VALUES(?, ?, ?)";
        return CrudUtil.execute(sql, order.getOrder_id(), order.getSup_id(), order.getDate());
    }

    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT order_id FROM sup_order ORDER BY order_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextOrderId(result.getString(1));
        }
        return generateNextOrderId("D");
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId.equals("D")){
            return "D01";
        }
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("D0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "D0" + id;
        }

        return "D01";

    }
}
