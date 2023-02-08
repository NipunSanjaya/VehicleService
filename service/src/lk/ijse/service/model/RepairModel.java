package lk.ijse.service.model;

import lk.ijse.service.to.AppointmentCartDelail;
import lk.ijse.service.dao.CrudUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RepairModel {
    public static boolean save(String appoiId, ArrayList<AppointmentCartDelail> appointmentDetail) throws SQLException, ClassNotFoundException {

        for (AppointmentCartDelail cartDetail : appointmentDetail) {
            if (!saveRepair(cartDetail,appoiId)) {
                return false;
            }
        }
        return true;

    }

    private static boolean saveRepair(AppointmentCartDelail cartDetail, String appoiId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO repair VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, appoiId, cartDetail.getSer_id(),cartDetail.getVeh_num(), LocalDate.now());
    }
}
