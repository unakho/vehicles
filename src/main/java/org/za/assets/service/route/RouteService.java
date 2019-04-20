package org.za.assets.service.route;

import org.za.assets.dto.RouteDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface RouteService<T extends BaseDto> extends AssetsService<BaseDto> {

    List<RouteDto> list();

    RouteDto get(UUID id)throws Exception;

    RouteDto create(RouteDto license)throws Exception;

    RouteDto update(RouteDto license)throws Exception;

    void remove(UUID id)throws Exception;
}
