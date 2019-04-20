package org.za.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.za.assets.domain.Profile;
import org.za.assets.domain.Route;

import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface ProfileRepository extends CrudRepository<Profile, UUID> {
}
