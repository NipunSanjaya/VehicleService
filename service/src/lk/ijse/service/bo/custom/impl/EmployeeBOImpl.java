package lk.ijse.service.bo.custom.impl;

import lk.ijse.service.bo.custom.EmployeeBO;
import lk.ijse.service.dao.CrudUtil;
import lk.ijse.service.dao.DAOFactory;
import lk.ijse.service.dao.DAOType;
import lk.ijse.service.dao.custom.EmployeeDAO;
import lk.ijse.service.dto.EmployeeDTO;
import lk.ijse.service.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAOFactory().getDAO(DAOType.EMPLOYEE);
    @Override
    public  boolean add(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getEmp_id(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getEmail()));
    }

    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
    @Override
    public  boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getEmp_id(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getEmail()));
    }
    @Override
    public  EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.search(id);
        return new EmployeeDTO(employee.getEmp_id(),employee.getName(), employee.getAddress(), employee.getContact(), employee.getEmail());
    }

    @Override
    public  ResultSet getTableValues() throws SQLException, ClassNotFoundException {
        return employeeDAO.getTableValues();
    }

    @Override
    public ArrayList<String> lordIds() throws SQLException, ClassNotFoundException {
        return null;
    }
}
