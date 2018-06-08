package org.za.assets.service.user;

import org.za.assets.dto.UserDto;
import org.za.assets.dto.base.IdDto;
import org.za.assets.service.base.AssetsService;

import java.util.List;

/**
 * @author unakho.kama
 */
public interface UserService<T extends IdDto> extends AssetsService<T> {

    List<UserDto> list();

    UserDto get(Long id);

    UserDto create(UserDto user);

    UserDto update(UserDto user);

    void remove(Long id);
}
