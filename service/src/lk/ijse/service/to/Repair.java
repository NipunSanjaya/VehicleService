package lk.ijse.service.to;

import java.time.LocalDate;

public class Repair {
    String apoi_id;
    String ser_id ;
    String veh_id ;
    LocalDate date;

    public Repair(String apoi_id, String ser_id, String veh_id, LocalDate date) {
        this.apoi_id = apoi_id;
        this.ser_id = ser_id;
        this.veh_id = veh_id;
        this.date = date;
    }

    public String getApoi_id() {
        return apoi_id;
    }

    public void setApoi_id(String apoi_id) {
        this.apoi_id = apoi_id;
    }

    public String getSer_id() {
        return ser_id;
    }

    public void setSer_id(String ser_id) {
        this.ser_id = ser_id;
    }

    public String getVeh_id() {
        return veh_id;
    }

    public void setVeh_id(String veh_id) {
        this.veh_id = veh_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
