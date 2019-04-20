package org.za.assets.service.license;

import org.za.assets.dto.LicenseDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface LicenseService<T extends BaseDto> extends AssetsService<BaseDto> {

    List<LicenseDto> list();

    LicenseDto get(UUID id)throws Exception;

    LicenseDto create(LicenseDto license)throws Exception;

    LicenseDto update(LicenseDto license)throws Exception;

    void remove(UUID id)throws Exception;
}
