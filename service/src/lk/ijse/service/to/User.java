package lk.ijse.service.to;

public class User {
    private String user_name;
    private String emp_id;
    private String email;
    private String role;
    private String password;

    public User(String user_name, String emp_id, String email, String role, String password) {
        this.user_name = user_name;
        this.emp_id = emp_id;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User(String user_name, String emp_id, String email, String role) {
        this.user_name = user_name;
        this.emp_id = emp_id;
        this.email = email;
        this.role = role;
    }

    public User(String user_name) {
        this.user_name = user_name;
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_id) {
        this.user_name = user_name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
