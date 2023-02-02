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
import lk.ijse.service.to.Employee;
import lk.ijse.service.view.tm.CustomerTM;

import java.sql.ResultSet;
import java.sql.SQLException;

import static lk.ijse.service.model.EmployeeModel.*;

public class EmployeeFormController {

    @FXML
    private AnchorPane paneEmployee;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnClear;

    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TableColumn<Employee,String> tblEmpId;

    @FXML
    private TableColumn<Employee,String> tblName;

    @FXML
    private TableColumn<Employee,String> tblAddress;

    @FXML
    private TableColumn<Employee,String> tblContact;

    @FXML
    private TableColumn<Employee,String> tblEmail;

    @FXML
    private TextField txtEmail;

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactoryCus();
        setObList();
    }
    public void setCellValueFactoryCus(){
        tblEmpId.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private ObservableList<Employee> obList= FXCollections.observableArrayList();

    public ObservableList setObList() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = EmployeeModel.getTableValues();
        while (resultSet.next()) {
            obList.add(new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
        }
        txtEmpId.requestFocus();
        tblEmployee.setItems(obList);
        return obList;
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String emp_id = txtEmpId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

        Employee employee = new Employee(emp_id,name,address,contact,email);

        boolean isAdded = add(employee);

        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Employee Added").show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
        }
        obList.clear();
        setObList();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

        txtEmpId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String emp_id = txtEmpId.getText();

        Employee employee = new Employee(emp_id);

        boolean isDeleted = delete(employee);

        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"Employee Deleted.!").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Something Happened...!").show();
        }
        obList.clear();
        setObList();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String emp_id = txtEmpId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

        Employee employee = new Employee(emp_id,name,address,contact,email);

        boolean isUpdated = update(employee);

        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Employee Updated.!").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Something Happened...!").show();
        }
        obList.clear();
        setObList();

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {
        txtContact.requestFocus();
    }

    @FXML
    void txtContactOnAction(ActionEvent event) {
        txtEmail.requestFocus();
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmpIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String emp_id = txtEmpId.getText();

        Employee employee = EmployeeModel.search(emp_id);

        if (employee != null){
            fillData(employee);
        }else{
            txtName.requestFocus();
        }

    }

    private void fillData(Employee employee) {
        txtEmpId.setText(employee.getEmp_id());
        txtName.setText(employee.getName());
        txtAddress.setText(employee.getAddress());
        txtContact.setText(employee.getContact());
        txtEmail.setText(employee.getEmail());
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtAddress.requestFocus();
    }


}
