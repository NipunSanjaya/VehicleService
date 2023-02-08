package lk.ijse.service.model;

import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupPaymentModel {
    public static String generateNextPaymentId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT pay_id FROM sup_payment ORDER BY pay_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextPaymentId(result.getString(1));
        }
        return generateNextPaymentId("P");
    }

    private static String generateNextPaymentId(String currentPaymentId) {
        if (currentPaymentId.equals("P")){
            return "P01";
        }
        if (currentPaymentId != null) {
            String[] split = currentPaymentId.split("P0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "P0" + id;
        }

        return "";

    }

}
