package org.za.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.za.assets.domain.Route;
import org.za.assets.domain.Schedule;

import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface ScheduleRepository extends CrudRepository<Schedule, UUID> {
}
