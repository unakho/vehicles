package org.za.assets.service.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Vehicle;
import org.za.assets.dto.VehicleDto;
import org.za.assets.repository.VehicleRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author unakho.kama
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> list() {

        Stream<Vehicle> stream = StreamSupport.stream(vehicleRepository.findAll().spliterator(), false);
        return stream.map(vehicle -> mapFrom(vehicle)).collect(Collectors.toList());
    }

    public VehicleDto get(Long id) {
        return mapFrom(vehicleRepository.findOne(id));
    }

    public VehicleDto create(VehicleDto dto) {

        Vehicle vehicle = mapTo(dto);
        vehicle = vehicleRepository.save(vehicle);

        return mapFrom(vehicle);
    }

    public VehicleDto update(VehicleDto dto) {

        Vehicle vehicle = mapTo(dto);
        vehicle = vehicleRepository.save(vehicle);

        return mapFrom(vehicle);
    }

    public void remove(Long id) {
        vehicleRepository.delete(id);
    }


    private Vehicle mapTo(VehicleDto dto) {

        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getId());
        vehicle.setName(dto.getName());
        vehicle.setModel(dto.getModel());
        vehicle.setType(dto.getType());
        vehicle.setRegNo(dto.getRegNo());

        return vehicle;
    }

    private VehicleDto mapFrom(Vehicle vehicle) {

        return new VehicleDto(vehicle.getId(), vehicle.getName(),
                vehicle.getModel(), vehicle.getType(), vehicle.getRegNo(), null);
    }
}
