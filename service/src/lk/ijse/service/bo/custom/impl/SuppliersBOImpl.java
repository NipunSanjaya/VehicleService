package lk.ijse.service.bo.custom.impl;

import lk.ijse.service.bo.custom.SuppliersBO;
import lk.ijse.service.dao.CrudUtil;
import lk.ijse.service.dao.DAOFactory;
import lk.ijse.service.dao.DAOType;
import lk.ijse.service.dao.custom.SuppliersDAO;
import lk.ijse.service.dto.SuppliersDTO;
import lk.ijse.service.entity.Suppliers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersBOImpl implements SuppliersBO {

    SuppliersDAO suppliersDAO = (SuppliersDAO) DAOFactory.getDAOFactory().getDAO(DAOType.SUPPLIERS);

    @Override
    public boolean save(SuppliersDTO dto) throws SQLException, ClassNotFoundException {
        return suppliersDAO.save(new Suppliers(dto.getSup_id(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getEmail()));
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return suppliersDAO.delete(id);
    }
    @Override
    public  boolean update(SuppliersDTO dto) throws SQLException, ClassNotFoundException {
        return suppliersDAO.update(new Suppliers(dto.getSup_id(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getEmail()));
    }
    @Override
    public  Suppliers search(String id) throws SQLException, ClassNotFoundException {
        return suppliersDAO.search(id);
    }
    @Override
    public  ArrayList<String> supId() throws SQLException, ClassNotFoundException {
        /*String sql = "select sup_id from suppliers";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> ids = new ArrayList<>();

        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;*/
        return null;
    }
    @Override
    public  String supName(String sup_id) throws SQLException, ClassNotFoundException {
        /*String sql = "select name from suppliers where sup_id =?";
        ResultSet result = CrudUtil.execute(sql, sup_id);

        if (result.next()) {
            return result.getString(1);
        }
        return "";*/
        return null;
    }
    @Override
    public  ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        return suppliersDAO.getTableValues();
    }
}
