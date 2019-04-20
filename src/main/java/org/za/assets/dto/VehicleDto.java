package org.za.assets.dto;

import org.za.assets.dto.base.NameDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class VehicleDto extends NameDto {

    private String model;
    private String type;
    private String regNo;
    private UserDto user;
    private LocalDateTime lastServiceDate;
    private LocalDateTime nextServiceDate;
    private List<ScheduleDto> schedules;

    public VehicleDto(UUID id, String name, String model, String type, String regNo,
                      LocalDateTime lastServiceDate, LocalDateTime
                              nextServiceDate) {
        super(id, name);
        this.model = model;
        this.type = type;
        this.regNo = regNo;
        this.lastServiceDate = lastServiceDate;
        this.nextServiceDate = nextServiceDate;
    }

    public VehicleDto(UUID id, String name, String model, String type, String regNo,
                      UserDto user, LocalDateTime lastServiceDate, LocalDateTime
                              nextServiceDate, List<ScheduleDto> schedules) {
        super(id, name);
        this.model = model;
        this.type = type;
        this.regNo = regNo;
        this.user = user;
        this.lastServiceDate = lastServiceDate;
        this.nextServiceDate = nextServiceDate;
        this.schedules = schedules;
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

    public LocalDateTime getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(LocalDateTime lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public LocalDateTime getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(LocalDateTime nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public List<ScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDto> schedules) {
        this.schedules = schedules;
    }
}
