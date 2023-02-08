package lk.ijse.service.bo.custom.impl;

import lk.ijse.service.bo.custom.ItemBO;
import lk.ijse.service.dao.CrudUtil;
import lk.ijse.service.dao.DAOFactory;
import lk.ijse.service.dao.DAOType;
import lk.ijse.service.dao.custom.ItemDAO;
import lk.ijse.service.dto.ItemDTO;
import lk.ijse.service.entity.Item;
import lk.ijse.service.to.CartDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOType.ITEM);
    @Override
    public  boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(dto.getItem_code(), dto.getName(), dto.getUnit_price(),dto.getQty_on_hand()));
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);

    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getItem_code(), dto.getName(), dto.getUnit_price(), dto.getQty_on_hand()));
    }
    @Override
    public ItemDTO search(String item_code) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.search(item_code);
        return new ItemDTO(item.getItem_code(),item.getName(), item.getUnit_price(), item.getQty_on_hand());
    }
    @Override
    public ArrayList<String> itemCodes() throws SQLException, ClassNotFoundException {
       return null;
    }
    @Override
    public ResultSet itemDetails(String item_code) throws SQLException, ClassNotFoundException {
        return itemDAO.getTableValues();
    }

    public boolean updateQty(ArrayList<CartDetail> orderDetails) throws SQLException, ClassNotFoundException {
        return Boolean.parseBoolean(null);
    }
    @Override
    public boolean updateQty(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return Boolean.parseBoolean(null);
    }
}
