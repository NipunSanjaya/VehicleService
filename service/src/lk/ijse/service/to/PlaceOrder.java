package lk.ijse.service.to;

import java.util.ArrayList;

public class PlaceOrder {
    private String sup_id;
    private String order_id;
    private String pay_id;
    private double netTotal;
    private ArrayList<CartDetail> orderDetails = new ArrayList<>();


    public PlaceOrder(String sup_id, String order_id, String pay_id, double netTotal, ArrayList<CartDetail> orderDetails) {
        this.sup_id = sup_id;
        this.order_id = order_id;
        this.pay_id = pay_id;
        this.netTotal = netTotal;
        this.orderDetails = orderDetails;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public ArrayList<CartDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<CartDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }
}
