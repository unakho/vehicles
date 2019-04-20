package org.za.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.za.assets.domain.Route;

import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface RouteRepository extends CrudRepository<Route, UUID> {
}
