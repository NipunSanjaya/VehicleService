package lk.ijse.service.entity;

public class Item {
    private String item_code;
    private String name;
    private double unit_price;
    private int qty_on_hand;

    public Item(String item_code) {
        this.item_code = item_code;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_code='" + item_code + '\'' +
                ", name='" + name + '\'' +
                ", unit_price=" + unit_price +
                ", qty_on_hand=" + qty_on_hand +
                '}';
    }

    public Item(String item_code, String name, double price, int qty_on_hand) {
        this.item_code = item_code;
        this.name = name;
        this.unit_price = price;
        this.qty_on_hand = qty_on_hand;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double price) {
        this.unit_price = price;
    }

    public int getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(int qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }
}
