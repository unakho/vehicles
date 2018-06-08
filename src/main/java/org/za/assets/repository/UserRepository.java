package org.za.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.za.assets.domain.User;

/**
 * @author unakho.kama
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
