package org.za.assets.service.vehicle;

import org.za.assets.dto.VehicleDto;
import org.za.assets.dto.base.IdDto;
import org.za.assets.service.base.AssetsService;

import java.util.List;

/**
 * @author unakho.kama
 */
public interface VehicleService<T extends IdDto> extends AssetsService<T> {

    List<VehicleDto> list();

    VehicleDto get(Long id);

    VehicleDto create(VehicleDto vehicle);

    VehicleDto update(VehicleDto vehicle);

    void remove(Long id);
}
