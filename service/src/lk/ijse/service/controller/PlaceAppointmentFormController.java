package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.dao.custom.impl.ServiceDAOImpl;
import lk.ijse.service.entity.Services;
import lk.ijse.service.model.*;
import lk.ijse.service.to.*;
import lk.ijse.service.util.Navigation;
import lk.ijse.service.util.Routes;
import lk.ijse.service.view.tm.PlaceAppointmentTM;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PlaceAppointmentFormController {

    @FXML
    private AnchorPane panePlaceAppointment;

    @FXML
    private TableView<PlaceAppointmentTM> tblPlaceAppointment;

    @FXML
    private TableColumn<?, ?> tblSerId;

    @FXML
    private TableColumn<?, ?> tblSerName;

    @FXML
    private TableColumn<?, ?> tblPrice;

    @FXML
    private TableColumn<?, ?> tblVehNum;

    @FXML
    private TableColumn<?, ?> tblAction;

    @FXML
    private JFXComboBox<String> cmbCusId;

    @FXML
    private JFXButton btnNewCustomer;

    @FXML
    private Label lblAppointmentId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblCusName;

    @FXML
    private JFXComboBox<String> cmbServiceId;

    @FXML
    private Label lblServiceName;

    @FXML
    private Label lblPrice;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private JFXButton btnPlaceAppointment;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblpaymentId;

    @FXML
    private JFXComboBox<String> cmbType;

    @FXML
    private JFXComboBox<String> cmbVehicleINum;

    @FXML
    private JFXButton btnNewVehicle;

    public void initialize() throws SQLException, ClassNotFoundException {
        lordAppointmentId();
        lordCusIds();
        lordDate();
        setCellValueFactory();
        lordTotal();
        lordVehicleTypes();
        lordPaymentId();

    }

    private void lordPaymentId() throws SQLException, ClassNotFoundException {
        String  payId = Cus_PaymentModel.generateNextpaymentId();
        lblpaymentId.setText(payId);
    }

    private ObservableList<String> vehicle_types = FXCollections.observableArrayList();

    public void lordVehicleTypes(){
        vehicle_types.add("Bike");
        vehicle_types.add("Car");
        vehicle_types.add("Van");
        vehicle_types.add("Three wheel");
        vehicle_types.add("Bus");
        vehicle_types.add("Lory");

        cmbType.setItems(vehicle_types);
    }

    private void lordVehicleNumbers(String cus_id) throws SQLException, ClassNotFoundException {
        /*ObservableList<String> veh_num = FXCollections.observableArrayList();
        ArrayList<String> vehicleNum = VehicleDAOImpl.lordVehNum(cus_id);

        for (String num : vehicleNum) {
            veh_num.add(num);
        }
        cmbVehicleINum.setItems(veh_num);*/
    }

    private void lordTotal() {
        lblTotal.setText(String.valueOf(fullTotal));
    }

    private void setCellValueFactory() {
        tblSerId.setCellValueFactory(new PropertyValueFactory("ser_id"));
        tblSerName.setCellValueFactory(new PropertyValueFactory("ser_name"));
        tblPrice.setCellValueFactory(new PropertyValueFactory("price"));
        tblVehNum.setCellValueFactory(new PropertyValueFactory("veh_num"));
        tblAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }

    private void lordServiceIds(String vehicleType) throws SQLException, ClassNotFoundException {
        /*ObservableList<String> ser_id = FXCollections.observableArrayList();
        ArrayList<String> servicesId = ServiceDAOImpl.lordIds(vehicleType);

        for (String id : servicesId) {
            ser_id.add(id);
        }
        cmbServiceId.setItems(ser_id);*/
    }

    private void lordDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    private void lordCusIds() throws SQLException, ClassNotFoundException {
     /*   ObservableList<String> cus_id = FXCollections.observableArrayList();
        ArrayList<String> customerId = CustomerDAOImpl.lordIds();

        for (String id : customerId) {
            cus_id.add(id);
        }
        cmbCusId.setItems(cus_id);*/
    }

    private void lordAppointmentId() throws SQLException, ClassNotFoundException {
        String  appointmentId = AppointmentModel.generateNextAppointmentId();
        lblAppointmentId.setText(appointmentId);
    }

    @FXML
    void cmbVehicleINumOnAction(ActionEvent event) {

    }

    private ObservableList<PlaceAppointmentTM> obList = FXCollections.observableArrayList();

    private double fullTotal;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String ser_id = String.valueOf(cmbServiceId.getValue());
        String ser_name = lblServiceName.getText();
        double price = Double.parseDouble(lblPrice.getText());
        String veh_num = String.valueOf(cmbVehicleINum.getValue());
        Button btnDelete = new Button("Delete");

        fullTotal += price;
        lordTotal();

        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                PlaceAppointmentTM tm = tblPlaceAppointment.getSelectionModel().getSelectedItem();

                tblPlaceAppointment.getItems().removeAll(tblPlaceAppointment.getSelectionModel().getSelectedItem());
//                tblOrderCart.refresh();
            }
        });
        obList.add(new PlaceAppointmentTM(ser_id, ser_name,price, veh_num, btnDelete));
        tblPlaceAppointment.setItems(obList);
    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, panePlaceAppointment);
    }

    @FXML
    void btnNewVehicleOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VEHICLE, panePlaceAppointment);
    }

    private double netTotal = 0;

    @FXML
    void btnPlaceAppointmentOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String appoi_id = lblAppointmentId.getText();
        String cus_id = String.valueOf(cmbCusId.getValue());
        String pay_id = lblpaymentId.getText();
        String veh_type = String.valueOf(cmbType.getValue());
        double net_total = Double.parseDouble(lblTotal.getText());
        ArrayList<AppointmentCartDelail> cartDetails = new ArrayList<>();

        for (int i = 0; i < tblPlaceAppointment.getItems().size(); i++) {

            PlaceAppointmentTM tm = obList.get(i);
            cartDetails.add(new AppointmentCartDelail(appoi_id, tm.getSer_id(), tm.getSer_name(), tm.getPrice(), tm.getVeh_num()));
            netTotal += tm.getPrice();
        }

        PlaceAppointment placeAppointment = new PlaceAppointment(appoi_id, pay_id, cus_id,veh_type, net_total, cartDetails);


        boolean isPlaced = PlaceAppointmentModel.placeAppointment(placeAppointment);
        if (isPlaced) {
            obList.clear();

            lordAppointmentId();
            lordPaymentId();
            new Alert(Alert.AlertType.CONFIRMATION, "Appointment Placed!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Appointment Not Placed!").show();
        }
    }

    @FXML
    void cmbCusIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    /*    String cus_id = String.valueOf(cmbCusId.getValue());
        lordVehicleNumbers(cus_id);

        Customer customer = CustomerDAOImpl.search(cus_id);
        lblCusName.setText(customer.getName());
*/
    }

    @FXML
    void cmbServiceIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        /*String ser_id = String.valueOf(cmbServiceId.getValue());
        Services services = ServiceDAOImpl.search(ser_id);
        lblServiceName.setText(services.getSer_name());
        lblPrice.setText(String.valueOf(services.getPrice()));*/
    }

    @FXML
    void cmbTypeOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String vehicleType = String.valueOf(cmbType.getValue());

        lordServiceIds(vehicleType);
    }

}
