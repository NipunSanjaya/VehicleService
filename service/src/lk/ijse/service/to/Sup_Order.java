package lk.ijse.service.to;

import java.time.LocalDate;

public class Sup_Order {
    private String order_id;
    private String sup_id;
    private LocalDate date;

    public Sup_Order(String order_id, String sup_id, LocalDate date) {
        this.order_id = order_id;
        this.sup_id = sup_id;
        this.setDate(date);
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
