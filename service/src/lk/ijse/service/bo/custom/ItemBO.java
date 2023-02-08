package lk.ijse.service.bo.custom;

import lk.ijse.service.bo.SuperBO;
import lk.ijse.service.dto.ItemDTO;
import lk.ijse.service.to.CartDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

    ItemDTO search(String item_code) throws SQLException, ClassNotFoundException;

    ArrayList<String> itemCodes() throws SQLException, ClassNotFoundException;

    ResultSet itemDetails(String item_code) throws SQLException, ClassNotFoundException;

    boolean updateQty(ArrayList<CartDetail> orderDetails) throws SQLException, ClassNotFoundException;

    boolean updateQty(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
}
