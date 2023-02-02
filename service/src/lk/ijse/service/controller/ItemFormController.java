package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.model.ItemModel;
import lk.ijse.service.to.Item;

import java.sql.SQLException;

import static lk.ijse.service.model.ItemModel.add;

public class ItemFormController {

    @FXML
    private AnchorPane paneItem;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TableView<?> tblItem;

    @FXML
    private TableColumn<?, ?> tblItemCode;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private TableColumn<?, ?> tblUnitPrice;

    @FXML
    private TableColumn<?, ?> tblQtyOnHand;

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
        String item_code = txtItemCode.getText();
        String name = txtName.getText();
        String unit_price = txtUnitPrice.getText();
        String qty_on_hand = txtQtyOnHand.getText();

        if (item_code.equals("")||name.equals("")||unit_price.equals("")||qty_on_hand.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            Item item = new Item(item_code, name, Double.parseDouble(unit_price), Integer.parseInt(qty_on_hand));

            boolean isAdded = add(item);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened...!").show();
            }
        }

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtItemCode.clear();
        txtName.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        String item_code = txtItemCode.getText();

        if (item_code.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            Item item = new Item(item_code);

            boolean isDeleted = ItemModel.delete(item);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Deleted.!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Happened...!").show();
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String item_code = txtItemCode.getText();
        String name = txtName.getText();
        String unit_price = txtUnitPrice.getText();
        String qty_on_hand = txtQtyOnHand.getText();

        if (item_code.equals("")||name.equals("")||unit_price.equals("")||qty_on_hand.equals("")){
            new Alert(Alert.AlertType.WARNING,"Some Data Fields Are Empty...!").show();
        }else {
            Item item = new Item(item_code, name, Double.parseDouble(unit_price), Integer.parseInt(qty_on_hand));

            boolean isUpdated = ItemModel.update(item);

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Updated.!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Happened...!").show();
            }
        }

    }@FXML
    void txtItemCodeOnHand(ActionEvent event) throws SQLException, ClassNotFoundException {
        String item_code = txtItemCode.getText();

        Item item = ItemModel.search(item_code);

        if (item != null){
            fillData(item);
        }else{
            txtName.requestFocus();
        }
    }

    private void fillData(Item item) {
        txtName.setText(item.getName());
        txtUnitPrice.setText(String.valueOf(item.getUnit_price()));
        txtQtyOnHand.setText(String.valueOf(item.getQty_on_hand()));
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtUnitPrice.requestFocus();
    }

    @FXML
    void txtQtyOnHandOnAction(ActionEvent event) {

    }

    @FXML
    void txtUnitPriceOnAction(ActionEvent event) {
        txtQtyOnHand.requestFocus();
    }

}
