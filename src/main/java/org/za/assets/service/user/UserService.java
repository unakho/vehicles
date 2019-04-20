package org.za.assets.service.user;

import org.za.assets.dto.UserDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface UserService<T extends BaseDto> extends AssetsService<T> {

    List<UserDto> list();

    Optional<UserDto> addVehicles(Optional<UserDto> user) throws Exception;

    Optional<UserDto> addProfiles(Optional<UserDto> user) throws Exception;

    Optional<UserDto> addRoutes(Optional<UserDto> user) throws Exception;

    Optional<UserDto> get(UUID id)throws Exception;

    Optional<UserDto> create(Optional<UserDto> user)throws Exception;

    Optional<UserDto> update(Optional<UserDto> user)throws Exception;

    void remove(UUID id)throws Exception;
}
