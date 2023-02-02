package lk.ijse.service.to;

import java.time.LocalDate;

public class Appointment {
    private String appoiId;
    private String cusId;
    private LocalDate date;

    public Appointment(String appoiId, String cusId, LocalDate date) {
        this.appoiId = appoiId;
        this.cusId = cusId;
        this.date = date;
    }

    public String getAppoiId() {
        return appoiId;
    }

    public void setAppoiId(String appoiId) {
        this.appoiId = appoiId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
