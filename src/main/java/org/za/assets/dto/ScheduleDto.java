package org.za.assets.dto;

import org.za.assets.dto.base.BaseDto;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class ScheduleDto extends BaseDto {

    private LocalDateTime date;
    private VehicleDto vehicle;

    public ScheduleDto(UUID id, LocalDateTime date) {
        super(id);
        this.date = date;
    }

    public ScheduleDto(UUID id, LocalDateTime date, VehicleDto vehicle) {
        super(id);
        this.date = date;
        this.vehicle = vehicle;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }
}
