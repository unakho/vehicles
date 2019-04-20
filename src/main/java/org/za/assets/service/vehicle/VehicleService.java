package org.za.assets.service.vehicle;

import org.za.assets.dto.VehicleDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface VehicleService<T extends BaseDto> extends AssetsService<BaseDto> {

    //crud methods
    List<VehicleDto> list();

    VehicleDto get(UUID id)throws Exception;

    VehicleDto create(VehicleDto vehicle)throws Exception;

    VehicleDto update(VehicleDto vehicle)throws Exception;

    void remove(UUID id)throws Exception;
}
