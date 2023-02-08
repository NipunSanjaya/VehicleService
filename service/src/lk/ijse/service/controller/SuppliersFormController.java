package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.bo.BOFactory;
import lk.ijse.service.bo.BOType;
import lk.ijse.service.bo.custom.SuppliersBO;
import lk.ijse.service.dao.custom.impl.SuppliersDAOImpl;
import lk.ijse.service.dto.SuppliersDTO;
import lk.ijse.service.entity.Suppliers;

import java.sql.ResultSet;
import java.sql.SQLException;



public class SuppliersFormController {

    @FXML
    private AnchorPane paneEmployee;

    @FXML
    private TextField txtSupId;

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
    private TableView<Suppliers> tblSuppliers;

    @FXML
    private TableColumn<Suppliers,String> tblSupId;

    @FXML
    private TableColumn<Suppliers,String> tblName;

    @FXML
    private TableColumn<Suppliers,String> tblAddress;

    @FXML
    private TableColumn<Suppliers,String> tblContact;

    @FXML
    private TableColumn<Suppliers,String> tblEmail;

    @FXML
    private TextField txtEmail;

    SuppliersBO suppliersBO = (SuppliersBO) BOFactory.getBoFactory().getBO(BOType.SUPPLIERS);

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactoryCus();
        setObList();
    }
    public void setCellValueFactoryCus(){
        tblSupId.setCellValueFactory(new PropertyValueFactory<>("sup_id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private ObservableList<Suppliers> obList= FXCollections.observableArrayList();

    public ObservableList setObList() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = suppliersBO.getTableValues();
        while (resultSet.next()) {
            obList.add(new Suppliers(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
        }
        txtSupId.requestFocus();
        tblSuppliers.setItems(obList);
        return obList;
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String sup_id = txtSupId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

        Suppliers suppliers;
        if (sup_id.equals("")||name.equals("")||address.equals("")||contact.equals("")||email.equals("")) {

            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            //suppliers = new Suppliers(sup_id,name,address,contact,email);
            boolean isAdded = suppliersBO.save(new SuppliersDTO(sup_id,name,address,contact,email));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }
        obList.clear();
        setObList();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtSupId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String sup_id = txtSupId.getText();

        if (sup_id.equals("")) {

            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            //Suppliers suppliers = new Suppliers(sup_id);

            boolean isDeleted = suppliersBO.delete(sup_id);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Deleted").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }
        obList.clear();
        setObList();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String sup_id = txtSupId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

        if (sup_id.equals("")||name.equals("")||address.equals("")||contact.equals("")||email.equals("")) {

            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            //Suppliers suppliers = new Suppliers(sup_id, name, address, contact, email);

            boolean isUpdated = suppliersBO.update(new SuppliersDTO(sup_id, name, address, contact, email));

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Updated").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
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
    void txtNameOnAction(ActionEvent event) {
        txtAddress.requestFocus();
    }

    @FXML
    void txtSupIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String sup_id = txtSupId.getText();

        Suppliers suppliers = suppliersBO.search(sup_id);

        if (suppliers != null){
            fillData(suppliers);
        }else {
            txtName.requestFocus();
        }
    }

    private void fillData(Suppliers suppliers) {
        txtSupId.setText(suppliers.getSup_id());
        txtName.setText(suppliers.getName());
        txtAddress.setText(suppliers.getAddress());
        txtContact.setText(suppliers.getContact());
        txtEmail.setText(suppliers.getEmail());
    }


}
