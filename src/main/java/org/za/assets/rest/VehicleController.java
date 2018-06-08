package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.VehicleDto;
import org.za.assets.service.vehicle.VehicleService;

import java.util.List;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/list")
    public List<VehicleDto> list() {
        return vehicleService.list();
    }

    @RequestMapping(value = "/get")
    public void get(@PathVariable("id") Long id) {
        vehicleService.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public void create(@RequestBody VehicleDto vehicle) {
        vehicleService.create(vehicle);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        vehicleService.remove(id);
    }
}
