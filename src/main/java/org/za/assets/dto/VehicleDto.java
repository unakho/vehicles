package org.za.assets.dto;

import org.za.assets.dto.base.NameDto;

/**
 * @author unakho.kama
 */
public class VehicleDto extends NameDto {

    private String model;
    private String type;
    private String regNo;
    private UserDto user;

    public VehicleDto(Long id, String name, String model, String type, String regNo) {
        super(id, name);
        this.model = model;
        this.type = type;
        this.regNo = regNo;
    }

    public VehicleDto(Long id, String name, String model, String type, String regNo, UserDto user) {
        super(id, name);
        this.model = model;
        this.type = type;
        this.regNo = regNo;
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
