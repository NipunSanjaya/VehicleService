package lk.ijse.service.dto;

public class VehicleDTO {
    private String veh_id;
    private String cus_id;
    private String type;
    private String veh_name;

    public VehicleDTO(String veh_id, String cus_id, String type, String veh_name) {
        this.veh_id = veh_id;
        this.cus_id = cus_id;
        this.type = type;
        this.veh_name = veh_name;

    }

    public VehicleDTO(String veh_id) {
        this.veh_id = veh_id;
    }

    public String getVeh_id() {
        return veh_id;
    }

    public void setVeh_id(String veh_id) {
        this.veh_id = veh_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVeh_name() {
        return veh_name;
    }

    public void setVeh_num(String veh_name) {
        this.veh_name = veh_name;
    }
}
