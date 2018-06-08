package org.za.assets.service.route;

import org.za.assets.dto.RouteDto;
import org.za.assets.dto.base.IdDto;
import org.za.assets.service.base.AssetsService;

import java.util.List;

/**
 * @author unakho.kama
 */
public interface RouteService<T extends IdDto> extends AssetsService<T> {

    List<RouteDto> list();

    RouteDto get(Long id);

    RouteDto create(RouteDto route);

    RouteDto update(RouteDto route);

    void remove(Long id);
}
