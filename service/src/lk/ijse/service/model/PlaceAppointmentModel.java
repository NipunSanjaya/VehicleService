package lk.ijse.service.model;

import lk.ijse.service.db.DBConnection;
import lk.ijse.service.to.Appointment;
import lk.ijse.service.to.PlaceAppointment;
import lk.ijse.service.to.Repair;

import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceAppointmentModel {
    public static boolean placeAppointment(PlaceAppointment placeAppointment) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isAppointmentAdded = AppointmentModel.save(new Appointment(placeAppointment.getAppoiId(), placeAppointment.getCusId(), LocalDate.now()));
            if (isAppointmentAdded) {
                boolean isRepairAdded = RepairModel.save(placeAppointment.getAppoiId(),placeAppointment.getAppointmentDetail());
                if (isRepairAdded) {
                    boolean isCusPaymentAdded = Cus_PaymentModel.save(placeAppointment.getPayId(), placeAppointment.getAppoiId(),LocalDate.now(),placeAppointment.getNetTotal(),placeAppointment.getCusId());
                    if (isCusPaymentAdded) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
