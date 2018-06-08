package org.za.assets.service.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Route;
import org.za.assets.dto.RouteDto;
import org.za.assets.repository.RouteRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author unakho.kama
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<RouteDto> list() {

        Stream<Route> stream = StreamSupport.stream(routeRepository.findAll().spliterator(), false);
        return stream.map(route -> mapFrom(route)).collect(Collectors.toList());
    }

    public RouteDto get(Long id) {
        return mapFrom(routeRepository.findOne(id));
    }

    public RouteDto create(RouteDto dto) {

        Route route = mapTo(dto);
        route = routeRepository.save(route);

        return mapFrom(route);
    }

    public RouteDto update(RouteDto dto) {

        Route route = mapTo(dto);
        route = routeRepository.save(route);

        return mapFrom(route);
    }

    public void remove(Long id) {
        routeRepository.delete(id);
    }


    private Route mapTo(RouteDto dto) {

        Route route = new Route();
        route.setId(dto.getId());
        route.setStartAddress(dto.getStartAddress());
        route.setEndAddress(dto.getEndAddress());
        route.setMileage(dto.getMileage());

        return route;
    }

    private RouteDto mapFrom(Route route) {

        return new RouteDto(route.getId(), route.getStartAddress(),
                route.getEndAddress(), route.getMileage());
    }
}
