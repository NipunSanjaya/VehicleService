package lk.ijse.service.model;

import lk.ijse.service.dao.CrudUtil;

import java.sql.SQLException;
import java.time.LocalDate;

public class Sup_paymentModel {

    public static boolean save(String pay_id, String sup_id, String order_id, LocalDate now, double netTotal) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO sup_payment VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, pay_id,sup_id,order_id, LocalDate.now(),netTotal);
    }
}
