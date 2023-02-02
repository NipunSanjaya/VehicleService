package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.model.ServiceModel;
import lk.ijse.service.to.Services;

import java.sql.SQLException;

public class ServiceFormController {

    public void initialize(){
        setServices();
    }
    @FXML
    private AnchorPane paneService;

    @FXML
    private TextField txtServiceId;

    @FXML
    private ComboBox<?> cmbVehicleType;

    @FXML
    private ComboBox<?> cmbServiceType;

    @FXML
    private TextField txtPrice;

    @FXML
    private TableView<?> tblService;

    @FXML
    private TableColumn<?, ?> tblServiceId;

    @FXML
    private TableColumn<?, ?> tblServiceName;

    @FXML
    private TableColumn<?, ?> tblVehicleType;

    @FXML
    private TableColumn<?, ?> tblPrice;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnClear;

    ObservableList ser_type = FXCollections.observableArrayList();
    ObservableList veh_type = FXCollections.observableArrayList();

    public void setServices(){
        ser_type.add("Body Wash");
        ser_type.add("Full Service");

        veh_type.add("Bike");
        veh_type.add("Car");
        veh_type.add("Van");
        veh_type.add("Lory");
        veh_type.add("Bus");

        cmbServiceType.setItems(ser_type);
        cmbVehicleType.setItems(veh_type);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        String ser_id = txtServiceId.getText();
        String service_type = String.valueOf(cmbServiceType.getValue());
        String vehicle_type = String.valueOf(cmbVehicleType.getValue());
        String price = txtPrice.getText();

        if (ser_id.equals("")||service_type.equals("")||vehicle_type.equals("")||price.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            Services services = new Services(ser_id, service_type, vehicle_type, Double.parseDouble(price));

            boolean isAdded = ServiceModel.add(services);

            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Services Added ").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtServiceId.clear();
        cmbServiceType.setPromptText("Select Ser_type");
        txtPrice.clear();
        cmbVehicleType.setPromptText("Select Veh_type");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String ser_id = txtServiceId.getText();

        if (ser_id.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            Services services = new Services(ser_id);
            boolean isDeleted = ServiceModel.delete(services);

            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Services Deleted ").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }

        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String ser_id = txtServiceId.getText();
        String name = String.valueOf(cmbServiceType.getValue());
        String type = String.valueOf(cmbVehicleType.getValue());
        String price = txtPrice.getText();

        if (ser_id.equals("")||name.equals("")||type.equals("")||price.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            Services services = new Services(ser_id, name, type, Double.parseDouble(price));

            boolean isUpdated = ServiceModel.update(services);

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Services Updated ").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }
    }

    @FXML
    void cmbVehicleTypeOnAction(ActionEvent event) {
        txtPrice.requestFocus();
    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtServiceIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String ser_id = txtServiceId.getText();

        Services services = ServiceModel.search(ser_id);

        if (services != null){
            filldata(services);
        }else {
            cmbServiceType.requestFocus();
        }
    }

    private void filldata(Services services) {
        cmbServiceType.setPromptText(services.getSer_name());
        txtPrice.setText(String.valueOf(services.getPrice()));
        cmbVehicleType.setPromptText(services.getSer_type());
    }

    @FXML
    void cmbServiceTypeOnAction(ActionEvent event) {
        cmbVehicleType.requestFocus();
    }

}
