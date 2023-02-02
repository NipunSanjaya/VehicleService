package lk.ijse.service.to;

public class Customer {
    private String cus_id;
    private String name;
    private String address;
    private String contact;
    private String email;

    public Customer() {
    }

    public Customer(String cus_id, String name, String address, String contact, String email) {
        this.cus_id = cus_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public Customer(String name, String address, String contact, String email) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public Customer(String cus_id) {
        this.cus_id = cus_id;
    }


    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
