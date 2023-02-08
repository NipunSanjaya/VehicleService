package lk.ijse.service.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.service.dao.custom.impl.SuppliersDAOImpl;
import lk.ijse.service.model.*;
import lk.ijse.service.to.CartDetail;
import lk.ijse.service.to.PlaceOrder;
import lk.ijse.service.util.Navigation;
import lk.ijse.service.util.Routes;
import lk.ijse.service.view.tm.PlaceOrderTM;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PlaceOrderFormController {

    public void initialize() throws SQLException, ClassNotFoundException {
        lordOrderId();
        lordDate();
        lordPaymentId();
        lordSupplierId();
        loadItemCodes();
        cmbSupId.requestFocus();
        setCellValueFactory();
        lordTotal();
    }


    @FXML
    private AnchorPane paneItem;

    @FXML
    private TableView<PlaceOrderTM> tblPlaceOrder;

    @FXML
    private TableColumn<?, ?> tblItemCode;

    @FXML
    private TableColumn<?, ?> tblItemName;

    @FXML
    private TableColumn<?, ?> tblUnitPrice;

    @FXML
    private TableColumn tblQty;

    @FXML
    private TableColumn<?, ?> tblTotal;

    @FXML
    private TableColumn<?, ?> tblAction;

    @FXML
    private JFXComboBox<String> cmbSupId;

    @FXML
    private JFXButton btnNew;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblSupName;

    @FXML
    private JFXComboBox<String> cmbItemCode;

    @FXML
    private Label lblItemName;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblPayId;

    private void lordPaymentId() {

        try {
            String paymentId = SupPaymentModel.generateNextPaymentId();
            lblPayId.setText(paymentId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadItemCodes() {
       /* ObservableList<String> itemCodes = FXCollections.observableArrayList();
        try {
            ArrayList<String> iCodes = ItemDAOImpl.itemCodes();

            for (String id : iCodes) {
                itemCodes.add(id);
            }
            cmbItemCode.setItems(itemCodes);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    private void lordSupplierId() {
        /*ObservableList<String> sup_id = FXCollections.observableArrayList();
        try {
            ArrayList<String> supplierId = SuppliersDAOImpl.supId();

            for (String id : supplierId) {
                sup_id.add(id);
            }
            cmbSupId.setItems(sup_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


    }

    private void lordDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    private void lordOrderId() throws SQLException, ClassNotFoundException {
        String  orderId = SupOrderModel.generateNextOrderId();
        lblOrderId.setText(orderId);

    }

    private void lordTotal() {
        lblTotal.setText(String.valueOf(fullTotal));
    }


    private ObservableList<PlaceOrderTM> obList = FXCollections.observableArrayList();

    private double fullTotal;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

        String item_code = cmbItemCode.getValue();
        String item_name = lblItemName.getText();
        double unit_price = Double.parseDouble(lblUnitPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        double total = unit_price * qty;
        Button btnDelete = new Button("Delete");

        fullTotal += total;
        lordTotal();
        txtQty.setText("");

        if (!obList.isEmpty()) {
            for (int i = 0; i < tblPlaceOrder.getItems().size(); i++) {
                if (tblItemCode.getCellData(i).equals(item_code)) {
                    qty += (int) tblQty.getCellData(i);
                    total = unit_price * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);
                    tblPlaceOrder.refresh();
                    return;
                }
            }
        }

        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                PlaceOrderTM tm = tblPlaceOrder.getSelectionModel().getSelectedItem();

                tblPlaceOrder.getItems().removeAll(tblPlaceOrder.getSelectionModel().getSelectedItem());
//                tblOrderCart.refresh();
            }
        });
        obList.add(new PlaceOrderTM(item_code, item_name,unit_price, qty, total, btnDelete));
        tblPlaceOrder.setItems(obList);
    }

    @FXML
    void btnNewOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIERS, paneItem);
    }

    public double netTotal = 0;

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        String order_id = lblOrderId.getText();
        String sup_id = String.valueOf(cmbSupId.getValue());
        String pay_id = lblPayId.getText();

        ArrayList<CartDetail> cartDetails = new ArrayList<>();

        for (int i = 0; i < tblPlaceOrder.getItems().size(); i++) {

            PlaceOrderTM tm = obList.get(i);
            cartDetails.add(new CartDetail(order_id, tm.getItem_code(), tm.getItem_name(), tm.getUnit_price(), tm.getQty(), tm.getTotal()));
            netTotal += tm.getTotal();
        }

        PlaceOrder placeOrder = new PlaceOrder(sup_id, order_id, pay_id,netTotal, cartDetails);


        boolean isPlaced = PlaceOrderModel.placeOrder(placeOrder);
        if (isPlaced) {
            obList.clear();

            lordOrderId();
            lordPaymentId();
            new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Order Not Placed!").show();
        }
    }

    @FXML
    void cmbItemCodeOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
  /*      String item_code = String.valueOf(cmbItemCode.getValue());
        ResultSet list = ItemDAOImpl.itemDetails(item_code);

        if (list.next()){
            lblItemName.setText(list.getString(1));
            lblUnitPrice.setText(String.valueOf(list.getDouble(2)));
            lblQtyOnHand.setText(String.valueOf(list.getInt(3)));
        }
        txtQty.requestFocus();*/
    }

    @FXML
    void cmbSupIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
       /* String sup_id = String.valueOf(cmbSupId.getValue());
        lblSupName.setText(SuppliersDAOImpl.supName(sup_id));
        cmbItemCode.requestFocus();*/
    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

    private void setCellValueFactory() {
        tblItemCode.setCellValueFactory(new PropertyValueFactory("item_code"));
        tblItemName.setCellValueFactory(new PropertyValueFactory("item_name"));
        tblUnitPrice.setCellValueFactory(new PropertyValueFactory("unit_price"));
        tblQty.setCellValueFactory(new PropertyValueFactory("qty"));
        tblTotal.setCellValueFactory(new PropertyValueFactory("total"));
        tblAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }

}
