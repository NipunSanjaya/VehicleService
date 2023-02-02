package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.model.CustomerModel;
import lk.ijse.service.model.UserModel;
import lk.ijse.service.model.VehicleModel;
import lk.ijse.service.to.User;
import lk.ijse.service.to.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.service.model.VehicleModel.add;

public class VehicleFormController {

    public void initialize() throws SQLException, ClassNotFoundException {
        lordCusIds();
        lordVehicleTypes();
    }

    @FXML
    private AnchorPane paneVehicle;

    @FXML
    private TextField txtVehicleNum;

    @FXML
    private TextField txtVehicleName;

    @FXML
    private ComboBox<String> cmbCusId;

    @FXML
    private TableView<?> tblVehicle;

    @FXML
    private TableColumn<?, ?> tblVehicleNum;

    @FXML
    private TableColumn<?, ?> tblVehicleName;

    @FXML
    private TableColumn<?, ?> tblType;

    @FXML
    private TableColumn<?, ?> tblCusId;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnClear;

    private ObservableList<String> vehicle_types = FXCollections.observableArrayList();
    private ObservableList<String> cus_ids = FXCollections.observableArrayList();

    public void lordVehicleTypes(){
        vehicle_types.add("Bike");
        vehicle_types.add("Car");
        vehicle_types.add("Van");
        vehicle_types.add("Three wheel");
        vehicle_types.add("Bus");
        vehicle_types.add("Lory");

        cmbType.setItems(vehicle_types);
    }

    public void lordCusIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> customerIds = CustomerModel.lordIds();

        for (String ids : customerIds) {
            cus_ids.add(ids);
        }
        cmbCusId.setItems(cus_ids);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String veh_id = txtVehicleNum.getText();
        String cus_id = String.valueOf(cmbCusId.getValue());
        String type = String.valueOf(cmbType.getValue());
        String veh_name = txtVehicleName.getText();

        if (veh_id.equals("")||cus_id.equals("")||type.equals("")||veh_name.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();

        }else {
            Vehicle vehicle = new Vehicle(veh_id,cus_id,type,veh_name);

            boolean isAdded = add(vehicle);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Added ").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtVehicleNum.clear();
        cmbCusId.setPromptText("Select customer ID");
        cmbType.setPromptText("Select Vehicle Type");
        txtVehicleName.clear();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String veh_id = txtVehicleNum.getText();


        if (veh_id.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();

        }else {
            Vehicle vehicle = new Vehicle(veh_id);

            boolean isDeleted = VehicleModel.delete(vehicle);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Deleted ").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        String veh_id = txtVehicleNum.getText();
        String cus_id = String.valueOf(cmbCusId.getValue());
        String type = String.valueOf(cmbType.getValue());
        String veh_name = txtVehicleName.getText();

        if (veh_id.equals("")||cus_id.equals("")||type.equals("")||veh_name.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();

        }else {
            Vehicle vehicle = new Vehicle(veh_id,cus_id,type,veh_name);

            boolean isUpdated = VehicleModel.update(vehicle);

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Updated ").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }
    }

    @FXML
    void cmbCusIdOnAction(ActionEvent event) {
        cmbType.requestFocus();
    }

    @FXML
    void cmbTypeOnAction(ActionEvent event) {
        txtVehicleName.requestFocus();
    }

    @FXML
    void txtVehicleNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtVehicleNumOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String veh_id = txtVehicleNum.getText();

        Vehicle vehicle = VehicleModel.search(veh_id);

        if (vehicle != null){
            filData(vehicle);
        }else {
            cmbCusId.requestFocus();
        }
    }

    private void filData(Vehicle vehicle) {
        cmbCusId.setPromptText(vehicle.getCus_id());
        cmbType.setPromptText(vehicle.getType());
        txtVehicleName.setText(vehicle.getVeh_name());
    }

}
