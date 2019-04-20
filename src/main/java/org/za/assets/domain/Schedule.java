package org.za.assets.domain;

import org.za.assets.domain.base.BaseEntity;
import org.za.assets.dto.ScheduleDto;
import org.za.assets.service.utils.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "schedule")
public class Schedule extends BaseEntity {

    @Column(name = "scheduled_date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public Schedule() {
    }

    private Schedule(UUID id, Timestamp date, Vehicle vehicle) {
        super(id);
        this.date = date;
        this.vehicle = vehicle;
    }

    private Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /*
     * @param dto
     * @return schedule entity
     * This method is used by services that are related with Route entity
     * @link ScheduleServiceImpl
     */
    public Schedule mapTo(ScheduleDto dto) {

        if (dto == null)
            throw new RuntimeException("Schedule dto is null!");

        return new Schedule(dto.getId(), new LocalDateTimeAttributeConverter()
                .convertToDatabaseColumn(dto.getDate()), this.getVehicle().mapTo(dto.getVehicle()));
    }

    /*
     * @param schedule
     * @return schedule dto
     * This method is used by services that are related with Route entity
     * @link ScheduleServiceImpl
     */
    public ScheduleDto mapFrom(Schedule schedule) {

        if (schedule == null)
            throw new RuntimeException("Schedule entity is null!");

        return new ScheduleDto(schedule.getId(), new LocalDateTimeAttributeConverter()
                .convertToEntityAttribute(schedule.getDate()), schedule.getVehicle().mapFrom(schedule.getVehicle()));
    }
}
