package org.za.assets.service.profile;

import org.za.assets.dto.ProfileDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface ProfileService<T extends BaseDto> extends AssetsService<BaseDto> {
    List<ProfileDto> list();

    ProfileDto get(UUID id)throws Exception;

    ProfileDto create(ProfileDto profile)throws Exception;

    ProfileDto update(ProfileDto profile)throws Exception;

    void remove(UUID id)throws Exception;
}
