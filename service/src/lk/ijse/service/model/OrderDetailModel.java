package lk.ijse.service.model;

import lk.ijse.service.to.CartDetail;
import lk.ijse.service.dao.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailModel {

    public static boolean saveOrderDetails(ArrayList<CartDetail> orderDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : orderDetails) {
            if (!save(cartDetail)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO order_detail VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, cartDetail.getOrder_id(), cartDetail.getItem_code(), cartDetail.getUnit_price(), cartDetail.getQty());
    }
}
