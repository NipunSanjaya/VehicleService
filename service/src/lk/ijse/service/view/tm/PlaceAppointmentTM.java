package lk.ijse.service.view.tm;

import javafx.scene.control.Button;
import lk.ijse.service.to.AppointmentCartDelail;

import java.util.ArrayList;

public class PlaceAppointmentTM {
    private String ser_id;
    private String ser_name;
    private double price;
    private String veh_num;
    private Button btnDelete;

    public PlaceAppointmentTM(String ser_id, String ser_name, double price, String veh_num, Button btnDelete) {
        this.ser_id = ser_id;
        this.ser_name = ser_name;
        this.price = price;
        this.veh_num = veh_num;
        this.btnDelete = btnDelete;
    }

    public PlaceAppointmentTM(String ser_id, String ser_name, double price, String veh_num) {
        this.ser_id = ser_id;
        this.ser_name = ser_name;
        this.price = price;
        this.veh_num = veh_num;
    }

    public PlaceAppointmentTM(String appoi_id, String pay_id, String cus_id, String veh_type, ArrayList<AppointmentCartDelail> cartDetails) {

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

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public String getVeh_num() {
        return veh_num;
    }

    public void setVeh_num(String veh_num) {
        this.veh_num = veh_num;
    }
}
