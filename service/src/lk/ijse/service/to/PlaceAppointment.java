package lk.ijse.service.to;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlaceAppointment {
    private String appoiId;
    private String payId;
    private String cusId;
    private String vehType;
    private double netTotal;
    private ArrayList<AppointmentCartDelail> appointmentDetail;

    public PlaceAppointment(String appoiId, String payId, String cusId, String vehType, double netTotal, ArrayList<AppointmentCartDelail> appointmentDetail) {
        this.appoiId = appoiId;
        this.payId = payId;
        this.cusId = cusId;
        this.vehType = vehType;
        this.netTotal = netTotal;
        this.appointmentDetail = appointmentDetail;
    }

    public String getAppoiId() {
        return appoiId;
    }

    public void setAppoiId(String appoiId) {
        this.appoiId = appoiId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public ArrayList<AppointmentCartDelail> getAppointmentDetail() {
        return appointmentDetail;
    }

    public void setAppointmentDetail(ArrayList<AppointmentCartDelail> appointmentDetail) {
        this.appointmentDetail = appointmentDetail;
    }
}