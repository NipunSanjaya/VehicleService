package lk.ijse.service.to;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Sup_payment {
    private String pay_id;
    private String sup_id;
    private String order_id;
    private LocalDate date;
    private double amount;
    private ArrayList<CartDetail> orderDetails = new ArrayList<>();

    public Sup_payment(String pay_id, String sup_id, String order_id, LocalDate date, double amount) {
        this.pay_id = pay_id;
        this.sup_id = sup_id;
        this.order_id = order_id;
        this.setDate(date);
        this.amount = amount;
    }

    public Sup_payment(String pay_id, String sup_id, String order_id, LocalDate date, ArrayList<CartDetail> orderDetails) {
        this.pay_id = pay_id;
        this.sup_id = sup_id;
        this.order_id = order_id;
        this.date = date;

        this.orderDetails = orderDetails;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<CartDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<CartDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
