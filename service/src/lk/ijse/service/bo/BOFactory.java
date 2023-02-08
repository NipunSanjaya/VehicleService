package lk.ijse.service.bo;

import lk.ijse.service.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    public static BOFactory getBoFactory(){
        return  (boFactory == null) ? boFactory=new BOFactory() :  boFactory;
    }
    public SuperBO getBO(BOType type){
        switch (type){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case SUPPLIERS:
                return new SuppliersBOImpl();
            case VEHICLE:
                return new VehicleBOImpl();
            case SERVICES:
                return new ServiceBOImpl();
            default:
                return null;
        }
    }
}
