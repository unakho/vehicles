package org.za.assets.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Schedule;
import org.za.assets.domain.Vehicle;
import org.za.assets.dto.ScheduleDto;
import org.za.assets.repository.ScheduleRepository;
import org.za.assets.repository.VehicleRepository;
import org.za.assets.service.CRUDService;
import org.za.assets.service.utils.LocalDateTimeAttributeConverter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Service
public class ScheduleServiceImpl extends CRUDService implements ScheduleService<ScheduleDto> {

    private VehicleRepository vehicleRepository;
    private Schedule schedule;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, VehicleRepository vehicleRepository) {
        super(scheduleRepository);
        this.vehicleRepository = vehicleRepository;
        schedule = new Schedule();
    }
    //return all schedules
    @Override
    public List<ScheduleDto> list() {

        return super.listRecords().map(entity -> {
            Schedule schedule = (Schedule)entity;

            return this.schedule.mapFrom(schedule);
        }).collect(Collectors.toList());
    }

    //search for a record using primary key id
    public ScheduleDto get(UUID id) throws Exception{

        Schedule schedule = (Schedule)super.getRecord(id);
        return this.schedule.mapFrom(schedule);
    }

    //schedule the vehicle
    public ScheduleDto create(ScheduleDto dto) throws Exception{

        Schedule schedule = this.schedule.mapTo(dto);
        if (dto.getVehicle().getId() == null)
             throw new Exception("Vehicle cannot be null when you schedule!");

        Vehicle vehicle = schedule.getVehicle();
        //schedule the vehicle to be used by drivers
        schedule.setVehicle(vehicle);
        return this.schedule.mapFrom((Schedule) super.createRecord(schedule));
    }

    public ScheduleDto update(ScheduleDto dto) throws Exception{

        Schedule schedule = this.schedule.mapTo(dto);
        //local time converter from timestamp to DateTime, virse-vesa
        LocalDateTimeAttributeConverter ldtac = new LocalDateTimeAttributeConverter();
        //we only update schedule date where we want postpone or reverse schedule
        schedule.setDate(ldtac.convertToDatabaseColumn(dto.getDate()));
        schedule = (Schedule)super.createRecord(schedule);

        return this.schedule.mapFrom(schedule);
    }

    public void remove(UUID id)throws Exception {
        super.removeRecord(id);
    }
}
