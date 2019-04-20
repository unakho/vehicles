package org.za.assets.service.license_type;

import org.za.assets.dto.LicenseTypeDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface LicenseTypeService<T extends BaseDto> extends AssetsService<BaseDto> {

    List<LicenseTypeDto> list();

    LicenseTypeDto get(UUID id)throws Exception;

    LicenseTypeDto create(LicenseTypeDto license)throws Exception;

    LicenseTypeDto update(LicenseTypeDto license)throws Exception;

    void remove(UUID id)throws Exception;
}
