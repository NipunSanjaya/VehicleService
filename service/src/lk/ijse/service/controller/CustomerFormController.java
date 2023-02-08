package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.service.bo.BOFactory;
import lk.ijse.service.bo.BOType;
import lk.ijse.service.bo.custom.CustomerBO;
import lk.ijse.service.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.service.dto.CustomerDTO;
import lk.ijse.service.entity.Customer;
import lk.ijse.service.view.tm.CustomerTM;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerFormController {
    CustomerBO customerBO =(CustomerBO) BOFactory.getBoFactory().getBO(BOType.CUSTOMER);

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactoryCus();
        setObList();
    }
    public void setCellValueFactoryCus(){
        colCus_id.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private ObservableList<CustomerTM> obList= FXCollections.observableArrayList();

    public ObservableList setObList() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = customerBO.getTableValues();
        while (resultSet.next()) {
            obList.add(new CustomerTM(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
        }
        txtCusId.requestFocus();
        tblCustomer.setItems(obList);
        return obList;
    }

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private TableColumn<CustomerTM,String> colCus_id;

    @FXML
    private TableColumn<CustomerTM,String> colName;

    @FXML
    private TableColumn<CustomerTM,String> colAddress;

    @FXML
    private TableColumn<CustomerTM,String> colContact;

    @FXML
    private TableColumn<CustomerTM,String> colEmail;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnClear;

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cus_id = txtCusId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

       // Customer customer = new Customer(cus_id,name,address,contact,email);


        boolean   isAdded = customerBO.saveCustomer(new CustomerDTO(cus_id,name,address,contact,email));

        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Added").show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
        }
        obList.clear();
        setObList();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtCusId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cus_id= txtCusId.getText();
      //  Customer customer = new Customer(cus_id);

        boolean isDeleted = customerBO.delete(cus_id);
        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted.!").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Something Happened...!").show();
        }
        obList.clear();
        setObList();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cus_id = txtCusId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

        //Customer customer = new Customer(cus_id,name, address, contact, email);

        boolean isUpdated = customerBO.update(new CustomerDTO(cus_id,name, address, contact, email));

        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Updated.!").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Something Happened...!").show();
        }
        obList.clear();
        setObList();
    }
    @FXML
    void txtCusIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cus_id = txtCusId.getText();

        CustomerDTO customer = customerBO.searchCustomer(cus_id);


        if (customer != null){
            fillData(customer);
        }else{
            txtName.requestFocus();
//            new Alert(Alert.AlertType.WARNING,"Customer Not Exits").show();
        }
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
    void txtNameOnAction(ActionEvent event) {
        txtAddress.requestFocus();
    }

    private void fillData(CustomerDTO customer) {
        txtCusId.setText(customer.getCus_id());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtContact.setText(customer.getContact());
        txtEmail.setText(customer.getEmail());
    }

}
