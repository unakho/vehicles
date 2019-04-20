package org.za.assets.service.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Route;
import org.za.assets.dto.RouteDto;
import org.za.assets.repository.RouteRepository;
import org.za.assets.service.CRUDService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Service
public class RouteServiceImpl extends CRUDService implements RouteService<RouteDto> {


    //private RouteRepository routeRepository;
    private Route route;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        super(routeRepository);
        this.route = new Route();
    }

    @Override
    public List<RouteDto> list() {

        return super.listRecords().map(entity -> {
            Route route = (Route) entity;

            return this.route.mapFrom(route);
        }).collect(Collectors.toList());
    }

    public RouteDto get(UUID id) throws Exception{
        return this.route.mapFrom((Route) super.getRecord(id));
    }

    public RouteDto create(RouteDto dto) throws Exception{

        Route route = this.route.mapTo(dto);
        route = (Route)super.createRecord(route);

        return this.route.mapFrom(route);
    }

    public RouteDto update(RouteDto dto) throws Exception{

        Route route = this.route.mapTo(dto);
        route = (Route)super.updateRecord(route);

        return this.route.mapFrom(route);
    }

    public void remove(UUID id) throws Exception{
        super.removeRecord(id);
    }
}
