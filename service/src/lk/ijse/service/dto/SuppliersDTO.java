package lk.ijse.service.dto;

public class SuppliersDTO {

    private String sup_id;
    private String name;
    private String address;
    private String contact;
    private String email;

    public SuppliersDTO(String sup_id, String name, String address, String contact, String email) {
        this.sup_id = sup_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public SuppliersDTO(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
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
