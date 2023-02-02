package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.service.util.Navigation;
import lk.ijse.service.util.Routes;

import java.io.IOException;

public class DashboardFormController {

    public void initialize() throws IOException {
        //lordUserPane();

    }

    private void lordUserPane() throws IOException {
        Navigation.navigate(Routes.USER,aPane);
    }

    @FXML
    private AnchorPane dashboardPane;

    @FXML
    private AnchorPane aPane;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnSupplier;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnService;

    @FXML
    private JFXButton btnLogout;

    @FXML
    void btnEmployeerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE, aPane);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ITEM,aPane);
    }

    @FXML
    void btnServiceOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SERVICE,aPane);
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIERS, aPane);
    }

    @FXML
    void btnUserOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.USER, aPane);
    }
    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN, dashboardPane);

    }
    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.PLACEORDER, aPane);
    }


}
