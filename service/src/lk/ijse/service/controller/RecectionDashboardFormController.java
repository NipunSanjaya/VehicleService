package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.util.Navigation;
import lk.ijse.service.util.Routes;

import java.io.IOException;

public class RecectionDashboardFormController {

    public  void initialize() throws IOException {
        //lordCustomerPane();
//        AnchorPane dashpane = FXMLLoader.load(getClass().getResource("/ik/ijse/service/view/recectionDashboardPane.fxml"));
//        rPane.getChildren().setAll(dashpane);

    }

    private void lordCustomerPane() throws IOException {
        Navigation.navigate(Routes.CUSTOMER, rPane);
    }

    @FXML
    private AnchorPane recectionDashboardPane;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnVehicle;

    @FXML
    private JFXButton btnAppointment;

    @FXML
    private JFXButton btnCusPayment;

    @FXML
    private JFXButton btnService;

    @FXML
    private AnchorPane rPane;

    @FXML
    private JFXButton btnLogout;

    @FXML
    void btnAppointmentOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.APPOINTMENT, rPane);
    }

    @FXML
    void btnCusPaymentOnAction(ActionEvent event) {

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, rPane);
    }

    @FXML
    void btnServiceOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SERVICE, rPane);
    }

    @FXML
    void btnVehicleOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VEHICLE, rPane);
    }
    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN, recectionDashboardPane);
    }

}
