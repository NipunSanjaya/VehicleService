package lk.ijse.service.dao.custom.impl;

import lk.ijse.service.dao.custom.ItemDAO;
import lk.ijse.service.entity.Item;
import lk.ijse.service.to.CartDetail;
import lk.ijse.service.dto.ItemDTO;
import lk.ijse.service.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    public  boolean save(Item entity) throws SQLException, ClassNotFoundException {
        String sql = "Insert into item values (?,?,?,?)";
        return CrudUtil.execute(sql, entity.getItem_code(), entity.getName(), entity.getUnit_price(), entity.getQty_on_hand());
    }

    public  boolean delete(String  id) throws SQLException, ClassNotFoundException {
        String  sql = "Delete from item where item_code = ?";
        return CrudUtil.execute(sql, id);
    }

    @Override
    public ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> lordIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean update(Item entity) throws SQLException, ClassNotFoundException {
        String sql = "update item set name=?, price=?, qty_on_hand=? where item_code=?";
        return CrudUtil.execute(sql, entity.getName(), entity.getUnit_price(), entity.getQty_on_hand(), entity.getItem_code());
    }

    public  Item search(String item_code) throws SQLException, ClassNotFoundException {
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

    public  ArrayList<String> itemCodes() throws SQLException, ClassNotFoundException {
        String sql = "select item_code from item";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> ids = new ArrayList<>();

        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }

    public  ResultSet itemDetails(String item_code) throws SQLException, ClassNotFoundException {
        String sql = "select name , price , qty_on_hand from item where item_code = ?";
        ResultSet result = CrudUtil.execute(sql, item_code);
        return result;

    }

    public  boolean updateQty(ArrayList<CartDetail> orderDetails) throws SQLException, ClassNotFoundException {

        for (CartDetail cartDetail : orderDetails) {
            if (!updateQty(new ItemDTO(cartDetail.getItem_code(), cartDetail.getItem_name(), cartDetail.getUnit_price(), cartDetail.getQty()))) {
                return false;
            }
        }
        return true;
    }
    private  boolean updateQty(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET qty_on_hand = qty_on_hand + ? WHERE item_code = ?";
        return CrudUtil.execute(sql, itemDTO.getQty_on_hand(), itemDTO.getItem_code());
    }
}
