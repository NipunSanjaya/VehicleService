package lk.ijse.service.to;

public class Services {
    private String ser_id;
    private String ser_name;
    private String ser_type;
    private double price;



    public Services(String ser_id, String ser_name, String ser_type, double price) {
        this.ser_id = ser_id;
        this.ser_name = ser_name;
        this.ser_type = ser_type;
        this.price = price;
    }

    public Services(String ser_id) {
        this.ser_id = ser_id;
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

    public String getSer_type() {
        return ser_type;
    }

    public void setSer_type(String ser_type) {
        this.ser_type = ser_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
