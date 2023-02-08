package lk.ijse.service.bo.custom.impl;

import lk.ijse.service.bo.custom.CustomerBO;
import lk.ijse.service.dao.DAOFactory;
import lk.ijse.service.dao.DAOType;
import lk.ijse.service.dao.custom.CustomerDAO;
import lk.ijse.service.dto.CustomerDTO;
import lk.ijse.service.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOType.CUSTOMER);
    @Override
    public  boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getCus_id(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getEmail()));
    }
    @Override
    public  CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(id);
        return new CustomerDTO(customer.getCus_id(),customer.getName(), customer.getAddress(), customer.getContact(), customer.getEmail());
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    @Override
    public  boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCus_id(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getEmail()));
    }
    @Override
    public ArrayList<CustomerDTO > lordIds() throws SQLException, ClassNotFoundException {
            ArrayList<Customer> customers = new ArrayList<>();
            ArrayList <CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer c: customers
             ) {
            customerDTOS.add(new CustomerDTO(c.getCus_id()));
        }return customerDTOS;
    }

    @Override
    public  ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        return customerDAO.getTableValues();
    }
}
