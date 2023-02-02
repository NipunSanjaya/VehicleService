package lk.ijse.service.model;

import lk.ijse.service.db.DBConnection;
import lk.ijse.service.to.PlaceOrder;
import lk.ijse.service.to.Sup_Order;


import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderModel {

    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {

        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrderAdded = SupOrderModel.save(new Sup_Order(placeOrder.getOrder_id(), placeOrder.getSup_id(), LocalDate.now()));
            if (isOrderAdded) {
                boolean isUpdated = ItemModel.updateQty(placeOrder.getOrderDetails());
                if (isUpdated) {
                    boolean isOrderDetailAdded = OrderDetailModel.saveOrderDetails(placeOrder.getOrderDetails());
                    if (isOrderDetailAdded) {
                        boolean isSupPaymentAdded = Sup_paymentModel.save(placeOrder.getPay_id(), placeOrder.getSup_id(),placeOrder.getOrder_id(), LocalDate.now(), placeOrder.getNetTotal());
                        if (isSupPaymentAdded){
                            DBConnection.getInstance().getConnection().commit();
                            return true;
                        }
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

}
