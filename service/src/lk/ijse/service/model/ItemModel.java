package lk.ijse.service.model;

import lk.ijse.service.to.CartDetail;
import lk.ijse.service.to.Item;
import lk.ijse.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static boolean add(Item item) throws SQLException, ClassNotFoundException {
        String sql = "Insert into item values (?,?,?,?)";
        return CrudUtil.execute(sql, item.getItem_code(), item.getName(), item.getUnit_price(), item.getQty_on_hand());
    }

    public static boolean delete(Item item) throws SQLException, ClassNotFoundException {
        String  sql = "Delete from item where item_code = ?";
        return CrudUtil.execute(sql, item.getItem_code());
    }

    public static boolean update(Item item) throws SQLException, ClassNotFoundException {
        String sql = "update item set name=?, price=?, qty_on_hand=? where item_code=?";
        return CrudUtil.execute(sql, item.getName(),item.getUnit_price(),item.getQty_on_hand(),item.getItem_code());
    }

    public static Item search(String item_code) throws SQLException, ClassNotFoundException {
        String sql = "select * from item where item_code = ?";
        ResultSet result = CrudUtil.execute(sql, item_code);

        if (result.next()){
            return new Item(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static ArrayList<String> itemCodes() throws SQLException, ClassNotFoundException {
        String sql = "select item_code from item";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> ids = new ArrayList<>();

        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }

    public static ResultSet itemDetails(String item_code) throws SQLException, ClassNotFoundException {
        String sql = "select name , price , qty_on_hand from item where item_code = ?";
        ResultSet result = CrudUtil.execute(sql, item_code);
        return result;

    }

    public static boolean updateQty(ArrayList<CartDetail> orderDetails) throws SQLException, ClassNotFoundException {

        for (CartDetail cartDetail : orderDetails) {
            if (!updateQty(new Item(cartDetail.getItem_code(), cartDetail.getItem_name(), cartDetail.getUnit_price(), cartDetail.getQty()))) {
                return false;
            }
        }
        return true;
    }
    private static boolean updateQty(Item item) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET qty_on_hand = qty_on_hand + ? WHERE item_code = ?";
        return CrudUtil.execute(sql, item.getQty_on_hand(), item.getItem_code());
    }
}
