package org.za.assets.dto;

import org.za.assets.dto.base.IdDto;

/**
 * @author unakho.kama
 */
public class RouteDto extends IdDto {

    private String startAddress;
    private String endAddress;
    private Double mileage;
    private UserDto user;

    public RouteDto(Long id, String startAddress, String endAddress, Double mileage) {
        super(id);
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.mileage = mileage;
    }

    public RouteDto(Long id, String startAddress, String endAddress, Double mileage, UserDto user) {
        super(id);
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.mileage = mileage;
        this.user = user;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
