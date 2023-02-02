package lk.ijse.service.to;

import java.util.Date;

public class Cus_Payment {
    private String pay_id;
    private String apoi_id;
    private Date date;
    private double amount;
    String cus_id;

    public Cus_Payment(String pay_id, String apoi_id, Date date, double amount, String cus_id) {
        this.pay_id = pay_id;
        this.apoi_id = apoi_id;
        this.date = date;
        this.amount = amount;
        this.cus_id = cus_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getApoi_id() {
        return apoi_id;
    }

    public void setApoi_id(String apoi_id) {
        this.apoi_id = apoi_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
