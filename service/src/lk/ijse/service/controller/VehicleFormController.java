package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.bo.BOFactory;
import lk.ijse.service.bo.BOType;
import lk.ijse.service.bo.custom.CustomerBO;
import lk.ijse.service.bo.custom.VehicleBO;
import lk.ijse.service.dao.custom.CustomerDAO;
import lk.ijse.service.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.service.dto.CustomerDTO;
import lk.ijse.service.dto.VehicleDTO;
import lk.ijse.service.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;


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

    VehicleBO vehicleBO = (VehicleBO) BOFactory.getBoFactory().getBO(BOType.VEHICLE);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOType.CUSTOMER);

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
        ArrayList<CustomerDTO> customerIds = customerBO.lordIds();
        for (CustomerDTO c: customerIds
             ) {
            cmbCusId.getItems().add(c.getCus_id());
        }


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
            //Vehicle vehicle = new Vehicle(veh_id,cus_id,type,veh_name);

            boolean isAdded = vehicleBO.save(new VehicleDTO(veh_id,cus_id,type,veh_name));

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
            //Vehicle vehicle = new Vehicle(veh_id);

            boolean isDeleted = vehicleBO.delete(veh_id);

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
            //Vehicle vehicle = new Vehicle(veh_id,cus_id,type,veh_name);

            boolean isUpdated = vehicleBO.update(new VehicleDTO(veh_id,cus_id,type,veh_name));

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

        Vehicle vehicle = vehicleBO.search(veh_id);

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
