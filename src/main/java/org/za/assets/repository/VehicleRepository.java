package org.za.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.za.assets.domain.Vehicle;

import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
}
