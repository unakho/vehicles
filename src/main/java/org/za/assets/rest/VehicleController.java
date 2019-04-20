package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.VehicleDto;
import org.za.assets.service.ServiceFactory;
import org.za.assets.service.vehicle.VehicleService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService<VehicleDto> vehicleService;

   /* public VehicleController() {
        vehicleService = (VehicleService<VehicleDto>)ServiceFactory.getService("vehicle");
    }*/

    @RequestMapping(value = "/list")
    public List<VehicleDto> list() {
        return vehicleService.list();
    }

    @RequestMapping(value = "/get")
    public void get(@PathVariable("id") UUID id)throws Exception {
        vehicleService.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public void create(@RequestBody VehicleDto vehicle)throws Exception {
        vehicleService.create(vehicle);
    }

    @RequestMapping(value = "/create/schedule", method = RequestMethod.PUT)
    public void scheduleVehicle(@RequestBody VehicleDto vehicle)throws Exception {
        vehicleService.create(vehicle);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        vehicleService.remove(id);
    }
}
