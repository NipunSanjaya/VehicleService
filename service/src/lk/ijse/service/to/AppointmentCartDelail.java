package lk.ijse.service.to;

public class AppointmentCartDelail {
    private String appointment_id;
    private String ser_id;
    private String ser_name;
    private double price;
    private String veh_num;

    public AppointmentCartDelail(String appointment_id, String ser_id, String ser_name, double price, String veh_num) {
        this.appointment_id = appointment_id;
        this.ser_id = ser_id;
        this.ser_name = ser_name;
        this.price = price;
        this.veh_num = veh_num;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getSer_id() {
        return ser_id;
    }

    public void setSer_id(String ser_id) {
        this.ser_id = ser_id;
    }

    public String getSer_name() {
        return ser_name;
    }

    public void setSer_name(String ser_name) {
        this.ser_name = ser_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVeh_num() {
        return veh_num;
    }

    public void setVeh_num(String veh_num) {
        this.veh_num = veh_num;
    }
}
