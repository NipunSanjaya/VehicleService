package lk.ijse.service.view.tm;

import javafx.scene.control.Button;

public class PlaceOrderTM {
    private String item_code;
    private String item_name;
    private double unit_price;
    private int qty;
    private double total;
    private Button btnDelete;

    public PlaceOrderTM(String item_code, String item_name, double unit_price, int qty, double total, Button btnDelete) {
        this.item_code = item_code;
        this.item_name = item_name;
        this.unit_price = unit_price;
        this.qty = qty;
        this.total = total;
        this.btnDelete = btnDelete;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
