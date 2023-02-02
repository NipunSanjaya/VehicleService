package lk.ijse.service.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route){
            case CUSTOMER:
                window.setTitle("Customer Manage Form");
                initUI("CustomerForm.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("Employee Manage Form");
                initUI("EmployeeForm.fxml");
                break;
            case ITEM:
                window.setTitle("Item Manage Form");
                initUI("ItemForm.fxml");
                break;
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;
            case SERVICE:
                window.setTitle("Service Manage Form");
                initUI("ServiceForm.fxml");
                break;
            case SUPPLIERS:
                window.setTitle("Suppliers Manage Form");
                initUI("SuppliersForm.fxml");
                break;
            case DASHBOARD:
                window.setTitle("Dashboard Form");
                initUI("DashboardForm.fxml");
                break;
            case USER:
                window.setTitle("User Manage Form");
                initUI("UserForm.fxml");
                break;
            case RECECTIONDASHBOARD:
                window.setTitle("Dashboard Form");
                initUI("RecectionDashboardForm.fxml");
                break;
            case PLACEORDER:
                window.setTitle("Place Order Form");
                initUI("PlaceOrderForm.fxml");
                break;
            case VEHICLE:
                window.setTitle("Vehicle Form");
                initUI("VehicleForm.fxml");
                break;
            case APPOINTMENT:
                window.setTitle("PlaceAppointment Form");
                initUI("PlaceAppointmentForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }

    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/service/view/" + location)));
    }
}
