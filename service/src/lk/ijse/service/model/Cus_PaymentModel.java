package lk.ijse.service.model;

import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Cus_PaymentModel {
    public static String generateNextpaymentId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT pay_id FROM cus_payment ORDER BY pay_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextpaymentId(result.getString(1));
        }
        return generateNextpaymentId("P");
    }

    private static String generateNextpaymentId(String currentPayId) {
        if (currentPayId.equals("P")){
            return "P01";
        }
        if (currentPayId != null) {

            String[] split = currentPayId.split("P0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "P0" + id;
        }

        return "P01";
    }

    public static boolean save(String payId, String appoiId, LocalDate now, double netTotal, String cusId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cus_payment VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, payId,appoiId,LocalDate.now(),netTotal,cusId);
    }
}
