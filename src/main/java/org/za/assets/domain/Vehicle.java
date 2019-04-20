package org.za.assets.domain;

import org.za.assets.domain.base.NameEntity;
import org.za.assets.dto.ProfileDto;
import org.za.assets.dto.ScheduleDto;
import org.za.assets.dto.VehicleDto;
import org.za.assets.service.utils.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "vehicle")
public class Vehicle extends NameEntity {

    private String model;
    private String type;

    @Column(name = "reg_no")
    private String regNo;

    @Column(name = "last_service")
    private Timestamp lastServiceDate;

    @Column(name = "next_service")
    private Timestamp nextServiceDate;

    @OneToMany(mappedBy = "vehicle")
    private List<Schedule> schedules;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public Vehicle() {
    }

    Vehicle(UUID id, String name, String model, String type, String regNo,
                   Timestamp lastServiceDate, Timestamp nextServiceDate) {
        super(id, name);
        setModel(model);
        setType(type);
        setRegNo(regNo);
        setLastServiceDate(lastServiceDate);
        setNextServiceDate(nextServiceDate);
    }

    public Vehicle(UUID id, String name, String model, String type, String regNo,
                   Timestamp lastServiceDate, Timestamp nextServiceDate, User user,
                   List<Schedule> schedules) {
        super(id, name);
        setModel(model);
        setType(type);
        setRegNo(regNo);
        setLastServiceDate(lastServiceDate);
        setNextServiceDate(nextServiceDate);
        setUser(user);
        setSchedule(schedules);
    }

    String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    String getRegNo() {
        return regNo;
    }

    private void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    private void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    Timestamp getNextServiceDate() {
        return nextServiceDate;
    }

    private void setNextServiceDate(Timestamp nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Schedule> getSchedule() {
        return schedules;
    }

    public void setSchedule(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    //lazily fetch profiles
    public List<ScheduleDto> getSchedulesDtos() {
        List<ScheduleDto> scheduleDtoList = getSchedule().stream().map(schedule -> schedule.mapFrom(schedule)).collect(Collectors.toList());

        return scheduleDtoList;
    }

    /*
     * @param vehicle dto
     * @return vehicle entity
     * This method is used by services that is why is public
     */
    public Vehicle mapTo(VehicleDto dto) {

        if (dto == null)
            throw new RuntimeException("Vehicle dto is null!");

        LocalDateTimeAttributeConverter ldtac = new LocalDateTimeAttributeConverter();

        return new Vehicle(dto.getId(), dto.getName(), dto.getModel(), dto.getType(), dto.getRegNo(),
                ldtac.convertToDatabaseColumn(dto.getLastServiceDate()), ldtac.convertToDatabaseColumn(
                dto.getNextServiceDate()));
    }

    /*
     * @param vehicle entity
     * @return vehicle dto
     * This method is used by services that is why is public
     */
    public VehicleDto mapFrom(Vehicle vehicle) {

        if (vehicle == null)
            throw new RuntimeException("Vehicle entity is null!");

        return new VehicleDto(vehicle.getId(), vehicle.getName(),
                vehicle.getModel(), vehicle.getType(), vehicle.getRegNo(),
                new LocalDateTimeAttributeConverter().convertToEntityAttribute(vehicle.getLastServiceDate())
                , new LocalDateTimeAttributeConverter().convertToEntityAttribute(vehicle.getNextServiceDate()));
    }
}
