package org.za.assets.service.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Vehicle;
import org.za.assets.dto.VehicleDto;
import org.za.assets.repository.VehicleRepository;
import org.za.assets.service.CRUDService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author unakho.kama
 */
@Service
public class VehicleServiceImpl extends CRUDService implements VehicleService<VehicleDto> {

    private VehicleRepository vehicleRepository;
    private Vehicle vehicle;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        super(vehicleRepository);
        vehicle = new Vehicle();
    }

    @Override
    public List<VehicleDto> list() {

        return super.listRecords().map(entity -> {
            Vehicle vehicle = (Vehicle)entity;

            return this.vehicle.mapFrom(vehicle);
        }).collect(Collectors.toList());
    }

    public VehicleDto get(UUID id) throws Exception{
        return this.vehicle.mapFrom((Vehicle) super.getRecord(id));
    }

    public VehicleDto create(VehicleDto dto) throws Exception{

        Vehicle vehicle = this.vehicle.mapTo(dto);
        vehicle = (Vehicle) super.createRecord(vehicle);

        return this.vehicle.mapFrom(vehicle);
    }

    public VehicleDto update(VehicleDto dto)throws Exception {

        Vehicle vehicle = this.vehicle.mapTo(dto);
        vehicle = (Vehicle) super.updateRecord(vehicle);

        return this.vehicle.mapFrom(vehicle);
    }

    public void remove(UUID id)throws Exception {
        super.removeRecord(id);
    }
}
