package lk.ijse.service.to;

public class Employee {
    private String emp_id;
    private String name;
    private String address;
    private String contact;
    private String email;

    public Employee(String cus_id, String name, String address, String contact, String email) {
        this.emp_id = cus_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }



    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public Employee(String emp_id) {
        this.emp_id = emp_id;
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
