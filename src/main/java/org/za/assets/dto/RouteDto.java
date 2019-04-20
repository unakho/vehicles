package org.za.assets.dto;

import org.za.assets.dto.base.BaseDto;

import java.util.UUID;


/**
 * @author unakho.kama
 */
public class RouteDto extends BaseDto {

    private String startAddress;
    private String endAddress;
    private Double mileage;
    private UserDto user;
    private LicenseDto license;
    private ScheduleDto schedule;

    public RouteDto(UUID id, String startAddress, String endAddress, Double mileage) {
        super(id);
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.mileage = mileage;
    }

    public RouteDto(UUID id, String startAddress, String endAddress,
                    Double mileage, UserDto user, LicenseDto license,
                    ScheduleDto schedule) {
        super(id);
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.mileage = mileage;
        this.user = user;
        this.license = license;
        this.schedule = schedule;
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

    public LicenseDto getLicense() {
        return license;
    }

    public void setLicense(LicenseDto license) {
        this.license = license;
    }

    public ScheduleDto getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDto schedule) {
        this.schedule = schedule;
    }
}
