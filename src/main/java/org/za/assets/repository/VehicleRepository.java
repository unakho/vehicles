package org.za.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.za.assets.domain.Vehicle;

/**
 * @author unakho.kama
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
