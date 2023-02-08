package lk.ijse.service.dao;

import lk.ijse.service.bo.BOType;
import lk.ijse.service.bo.SuperBO;
import lk.ijse.service.bo.custom.impl.CustomerBOImpl;
import lk.ijse.service.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory DAOFactory;

    private DAOFactory() {
    }
    public static DAOFactory getDAOFactory(){
        return  (DAOFactory == null) ? DAOFactory =new DAOFactory() : DAOFactory;
    }
    public SuperDAO getDAO(DAOType type){
        switch (type){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case SUPPLIERS:
                return new SuppliersDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            case SERVICES:
                return new ServiceDAOImpl();
            default:
                return null;
        }
    }
}
