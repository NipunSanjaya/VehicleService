package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.model.EmployeeModel;
import lk.ijse.service.model.UserModel;
import lk.ijse.service.to.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.service.model.UserModel.add;
import static lk.ijse.service.model.UserModel.update;

public class UserFormController {


    public void initialize() throws SQLException, ClassNotFoundException {
        lordEmp_ids();
        lordUserRole();
        setCellValueFactoryCus();
        setObList();
    }

    private void setCellValueFactoryCus() {
        colUser_name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
    }

    private ObservableList<User> obList= FXCollections.observableArrayList();

    public ObservableList setObList() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = UserModel.getTableValues();
        while (resultSet.next()) {
            obList.add(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
        }
        txtUserName.requestFocus();
        tblUser.setItems(obList);
        return obList;
    }

    @FXML
    private AnchorPane userPane;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TableView<User> tblUser;

    @FXML
    private TableColumn<?, ?> colUser_name;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private ComboBox<String> cmbEmpId;

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnClear;



    ObservableList<String> emp_ids = FXCollections.observableArrayList();
    ObservableList<String> roles = FXCollections.observableArrayList();

    private  void lordEmp_ids () throws SQLException, ClassNotFoundException {
        ArrayList<String> employeeList = EmployeeModel.loadEmployeeIds();

        for (String ids : employeeList) {
            emp_ids.add(ids);
        }
        cmbEmpId.setItems(emp_ids);
    }

    private void lordUserRole(){
        roles.add("Admin");
        roles.add("Reception");

        cmbRole.setItems(roles);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String user_name = txtUserName.getText();
        String emp_id = String.valueOf(cmbEmpId.getValue());
        String email = txtEmail.getText();
        String role = String.valueOf(cmbRole.getValue());
        String password = txtPassword.getText();
        String con_password = txtConfirmPassword.getText();

        if (user_name.equals("")||emp_id.equals("")||email.equals("")||role.equals("")||password.equals("")||con_password.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();

        }else {
            if (con_password.equals(password)) {
                User user = new User(user_name, emp_id, email, role, password);

                boolean isAdded = add(user);

                if (isAdded) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Services Added ").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
                }
            }else {
                new Alert(Alert.AlertType.WARNING,"Incorrect Password...!").show();
            }
        }


    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtUserName.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
        cmbRole.setPromptText("Select Role");
        cmbEmpId.setPromptText("Select Emp_Id");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String user_name = txtUserName.getText();

        if (user_name.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();

        }else {
                User user = new User(user_name);

                boolean isDeleted = UserModel.delete(user);

                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Deleted ").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
                }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String user_name = txtUserName.getText();
        String emp_id = String.valueOf(cmbEmpId.getValue());
        String email = txtEmail.getText();
        String role = String.valueOf(cmbRole.getValue());
        String password = txtPassword.getText();
        String con_password = txtConfirmPassword.getText();

        if (user_name.equals("")||emp_id.equals("")||email.equals("")||role.equals("")||password.equals("")||con_password.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();

        }else {
            if (con_password.equals(password)) {
                User user = new User(user_name, emp_id, email, role, password);

                boolean isUpdated = update(user);

                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Updated ").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
                }
            }else {
                new Alert(Alert.AlertType.WARNING,"Incorrect Password...!").show();
            }
        }
    }

    @FXML
    void cmbEmpIdOnAction(ActionEvent event) {
        txtEmail.requestFocus();
    }

    @FXML
    void cmbRoleOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void txtConfirmPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {
        cmbRole.requestFocus();
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        txtConfirmPassword.requestFocus();
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String user_name = txtUserName.getText();

        User user = UserModel.search(user_name);

        if (user != null){
            filData(user);
        }else {
            cmbEmpId.requestFocus();
        }
    }

    private void filData(User user) {
        txtUserName.setText(user.getUser_name());
        cmbEmpId.setPromptText(user.getEmp_id());
        txtEmail.setText(user.getEmail());
        cmbRole.setPromptText(user.getRole());
    }

}
