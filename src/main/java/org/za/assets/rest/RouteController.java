package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.RouteDto;
import org.za.assets.service.route.RouteService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService<RouteDto> routeService;

    @RequestMapping(value = "/list")
    public List<RouteDto> list() {
        return routeService.list();
    }

    @RequestMapping(value = "/get")
    public RouteDto get(@PathVariable("id") UUID id)throws Exception {
        return routeService.get(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public RouteDto create(@RequestBody RouteDto user)throws Exception {
        return routeService.create(user);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        routeService.remove(id);
    }
}
