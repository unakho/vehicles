package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.RouteDto;
import org.za.assets.dto.UserDto;
import org.za.assets.service.route.RouteService;

import java.util.List;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/list")
    public List<UserDto> list() {
        return routeService.list();
    }

    @RequestMapping(value = "/get")
    public RouteDto get(@PathVariable("id") Long id) {
        return routeService.get(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public RouteDto create(@RequestBody RouteDto user) {
        return routeService.create(user);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        routeService.remove(id);
    }
}
