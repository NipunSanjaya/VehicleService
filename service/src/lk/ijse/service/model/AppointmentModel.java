package lk.ijse.service.model;

import lk.ijse.service.to.Appointment;
import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentModel {
    public static String generateNextAppointmentId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT apoi_id FROM appointment ORDER BY apoi_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextAppointmentId(result.getString(1));
        }
        return generateNextAppointmentId("A");
    }

    private static String generateNextAppointmentId(String currentAppoiId) {
        if (currentAppoiId.equals("A")){
            return "A01";
        }
        if (currentAppoiId != null) {

            String[] split = currentAppoiId.split("A0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "A0" + id;
        }


        return "A01";
    }

    public static boolean save(Appointment appointment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO appointment VALUES(?, ?, ?)";
        return CrudUtil.execute(sql, appointment.getAppoiId(), appointment.getCusId(), appointment.getDate());
    }
}
