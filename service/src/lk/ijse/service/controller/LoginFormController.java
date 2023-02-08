package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.service.AppInitializer;
import lk.ijse.service.dao.CrudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private AnchorPane LoginForm;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblPassword;

    @FXML
    private JFXButton btnForgottenPassword;

    @FXML
    void btnForgottenPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {


        String userRole = getUserRole();
        if (userRole.equals("Admin")) {
            URL resource = getClass().getResource("/lk/ijse/service/view/DashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            AppInitializer.primaryStage1.close();
        }
        if (userRole.equals("Reception")) {
            //Navigation.navigate(Routes.DASHBOARD, LoginForm);

            URL resource = getClass().getResource("/lk/ijse/service/view/RecectionDashboardForm.fxml");
//        URL resource = getClass().getResource("/lk/ijse/service/view/DashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            AppInitializer.primaryStage1.close();
//            Navigation.navigate(Routes.CUSTOMER, rPane);

        }
//        AppInitializer.primaryStage1.show();

    }

    private String getUserRole() throws SQLException, ClassNotFoundException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if (userName.equals("") | password.equals("")) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Error");
            error.setHeaderText("Some data fields are empty");
            error.setContentText("Please Input user name and password");
            error.show();
        } else {
            String sql = "select password,role from user where user_Name=?";
            ResultSet resultSet = CrudUtil.execute(sql, userName);

            if (resultSet.next()) {
                boolean checkPassword = checkPassword(password, resultSet);
                if (checkPassword) {
                    return resultSet.getString(2);
                } else {
                    Alert error = new Alert(Alert.AlertType.WARNING);
                    error.setTitle("Error");
                    error.setHeaderText("Incorrect Password");
                    error.setContentText("User name and password not matched");
                    error.show();
                    lblPassword.setText("Incorrect Password");
                }

            } else {
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setTitle("Error");
                error.setHeaderText("Incorrect User name!");
                error.setContentText("Try Again!");
                error.show();
                lblUserName.setText("Incorrect User name!");
            }
        }
        return " ";
    }

    private boolean checkPassword(String password, ResultSet resultSet) throws SQLException {
        if (password.equals(resultSet.getString(1))) {
            return true;
        }
        return false;
    }
}
